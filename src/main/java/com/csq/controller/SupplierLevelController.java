package com.csq.controller;

import com.csq.dto.SupplierLevelDto;
import com.csq.entity.PageData;
import com.csq.entity.Supplier;
import com.csq.entity.SupplierLevel;
import com.csq.service.SupplierLevelService;
import com.csq.service.SupplierService;
import com.csq.utils.DefaultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("supplierLevelController")
public class SupplierLevelController {

    @Autowired
    SupplierLevelService supplierLevelService;
    @Autowired
    SupplierService supplierService;

    @RequestMapping("supplierLevelList")
    public String getAll(PageData pageData, Map<String, Object> map) {
        try {
            pageData = DefaultUtils.getPageData(pageData);
            List<SupplierLevel> supplierLevelListPre = supplierLevelService.getAllSupplierLevel(pageData);
            List<SupplierLevelDto> supplierLevelList = new ArrayList<>();
            for (SupplierLevel supplierLevel : supplierLevelListPre) {
                SupplierLevelDto dto = new SupplierLevelDto();
                dto.setId(supplierLevel.getId());
                dto.setLevel(supplierLevel.getLevel());
                dto.setRemarks(supplierLevel.getRemarks());
                dto.setTime(supplierLevel.getTime());
                Supplier supplier = supplierService.getSupplierById(supplierLevel.getSupplierId());
                dto.setName(supplier.getName());
                supplierLevelList.add(dto);
            }
            //得到总页数
            int pages = getPages(pageData.getLimit());
            pageData.setPages(pages);
            //得到当前页的总条数
            pageData.setCount(supplierLevelList.size());
            //设置当前页
            map.put("pageData", pageData);
            map.put("supplierLevelList", supplierLevelList);
            map.put("location", "supplierLevelList");
            return "supplierLevel";
        } catch (Exception e) {
            e.printStackTrace();
            return "supplierLevel";
        }
    }

    @RequestMapping("editSupplierLevel")
    public String editSupplierLevel(SupplierLevelDto supplierLevel, Map<String, Object> map) {
        try {
            Supplier supplier = supplierService.getSupplierByName(supplierLevel.getName());
            SupplierLevel supplierLevel1 = new SupplierLevel();
            supplierLevel1.setSupplierId(supplier.getId());
            supplierLevel1.setId(supplierLevel.getId());
            supplierLevel1.setTime(supplierLevel.getTime());
            supplierLevel1.setRemarks(supplierLevel.getRemarks());
            supplierLevel1.setLevel(supplierLevel.getLevel());
            supplierLevelService.editSupplierLevel(supplierLevel1);
            map.put("result", "编辑成功");
            map.put("href", "supplierLevelList");
        } catch (Exception e) {
            map.put("result", "编辑失败");
            map.put("href", "supplierLevelList");
            e.printStackTrace();
        }
        return "result";
    }

    @RequestMapping("deleteSupplierLevelById/{id}")
    public String deleteSupplierLevelById(@PathVariable("id") int id, Map<String, Object> map) {
        try {
            supplierLevelService.deleteSupplierLevelById(id);
            return "redirect:../supplierLevelList";
        } catch (Exception e) {
            map.put("result", "删除失败");
            map.put("href", "../supplierLevelList");
            e.printStackTrace();
            return "result";
        }
    }

    @RequestMapping("applySupplierLevel")
    public String applyMeterial() {
        return "supplierLevel";
    }

    @RequestMapping("addSupplierLevelPre")
    public String addSupplierLevelPre() {
        return "add_supplierLevel";
    }

    @RequestMapping("addSupplierLevel")
    public String addSupplier(SupplierLevelDto dto, Map<String, Object> map) {
        try {
            String name = dto.getName();
            Supplier supplier = supplierService.getSupplierByName(name);
            SupplierLevel supplierLevel = new SupplierLevel();
            supplierLevel.setId(dto.getId());
            supplierLevel.setLevel(dto.getLevel());
            supplierLevel.setRemarks(dto.getRemarks());
            supplierLevel.setTime(dto.getTime());
            supplierLevel.setSupplierId(supplier.getId());
            supplierLevelService.addSupplierLevel(supplierLevel);
            return "redirect:supplierLevelList";
        } catch (Exception e) {
            map.put("result", "增加失败");
            map.put("href", "supplierLevelList");
            e.printStackTrace();
            return "result";
        }
    }

    @RequestMapping("getSupplierLevelById/{id}")
    public String getSupplierById(@PathVariable("id") int id, Map<String, Object> map) {
        SupplierLevel supplierLevelPre = null;
        try {
            supplierLevelPre = supplierLevelService.getSupplierLevelById(id);
            SupplierLevelDto supplierLevel = new SupplierLevelDto();
            int supplierId = supplierLevelPre.getSupplierId();
            Supplier supplier = supplierService.getSupplierById(supplierId);
            supplierLevel.setName(supplier.getName());
            supplierLevel.setTime(supplierLevelPre.getTime());
            supplierLevel.setRemarks(supplierLevelPre.getRemarks());
            supplierLevel.setId(supplierLevelPre.getId());
            supplierLevel.setLevel(supplierLevelPre.getLevel());
            map.put("supplierLevel", supplierLevel);
            return "supplierLevelEdit";
        } catch (Exception e) {
            map.put("error", "暂无信息");
            map.put("result", "查询失败");
            map.put("href", "../supplierLevelList");
            return "result";
        }
    }

    private int getPages(int limit) {
        if (limit == 0) {
            limit = 10;
        }
        int count = supplierLevelService.getCount();
        int pages = count / limit;
        if (count % limit != 0) {
            pages++;
        }
        return pages;
    }
}
