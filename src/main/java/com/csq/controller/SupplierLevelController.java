package com.csq.controller;

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

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("supplierController")
public class SupplierLevelController {

    @Autowired
    SupplierLevelService supplierLevelService;
    @RequestMapping("supplierLevelList")
    public String getAll(PageData pageData, Map<String, Object> map) {
        try {

            pageData = DefaultUtils.getPageData(pageData);
            List<SupplierLevel> supplierLevelList = supplierLevelService.getAllSupplierLevel(pageData);
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
    public String editSupplier(SupplierLevel supplierLevel, Map<String, Object> map) {
        try {
            supplierLevelService.editSupplierLevel(supplierLevel);
            map.put("result", "编辑成功");
        } catch (Exception e) {
            map.put("result", "编辑失败");
            e.printStackTrace();
        }
        return "supplierLevelList";
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
    public String applyMeterial(){
        return "supplierLevel";
    }

    @RequestMapping("addSupplierLevel")
    public String addSupplier(SupplierLevel supplierLevel, Map<String, Object> map) {
        try {
            supplierLevelService.addSupplierLevel(supplierLevel);
            return "redirect:../supplierLevelList";
        } catch (Exception e) {
            map.put("result", "删除失败");
            map.put("href", "../supplierLevelList");
            e.printStackTrace();
            return "result";
        }
    }

    @RequestMapping("getSupplierLevelById/{id}")
    public String getSupplierById(@PathVariable("id") int id, Map<String, Object> map) {
        SupplierLevel supplierLevel = null;
        try {
            supplierLevel = supplierLevelService.getSupplierLevelById(id);
            map.put("supplier_level", supplierLevel);
            return "supplierLevel_edit";
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
