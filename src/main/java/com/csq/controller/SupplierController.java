package com.csq.controller;

import com.csq.entity.PageData;
import com.csq.entity.Supplier;
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
public class SupplierController {

    @Autowired
    SupplierService supplierService;
    @RequestMapping("supplierList")
    public String getAll(PageData pageData, Map<String, Object> map) {
        try {

            pageData = DefaultUtils.getPageData(pageData);
            List<Supplier> supplierList = supplierService.getAllSupplier(pageData);
            //得到总页数
            int pages = getPages(pageData.getLimit());
            pageData.setPages(pages);
            //得到当前页的总条数
            pageData.setCount(supplierList.size());
            //设置当前页
            map.put("pageData", pageData);
            map.put("supplierList", supplierList);
            map.put("location", "supplierList");
            return "supplier";
        } catch (Exception e) {
            e.printStackTrace();
            return "supplier";
        }
    }
    @RequestMapping("getSupplierById/{id}")
    public String getMeterialById(@PathVariable("id") int id, Map<String, Object> map) {
        Supplier supplier = null;
        try {
            supplier = supplierService.getSupplierById(id);
            map.put("supplier", supplier);
            return "supplier_edit";
        } catch (Exception e) {
            map.put("error", "暂无信息");
            map.put("result", "查询失败");
            map.put("href", "../supplierList");
            return "result";
        }
    }

    @RequestMapping("editSupplier")
    public String editSupplier(Supplier supplier, Map<String, Object> map) {
        try {
            supplierService.editSupplier(supplier);
            map.put("result", "编辑成功");
        } catch (Exception e) {
            map.put("result", "编辑失败");
            e.printStackTrace();
        }
        return "supplierList";
    }

    @RequestMapping("deleteSupplierById/{id}")
    public String deleteSupplierById(@PathVariable("id") int id, Map<String, Object> map) {
        try {
            supplierService.deleteSupplierById(id);
            return "redirect:../supplierList";
        } catch (Exception e) {
            map.put("result", "删除失败");
            map.put("href", "../supplierList");
            e.printStackTrace();
            return "result";
        }
    }
    @RequestMapping("applySupplier")
    public String applyMeterial(){
        return "supplier";
    }

    @RequestMapping("addSupplier")
    public String addSupplier(Supplier supplier, Map<String, Object> map) {
        try {
            supplierService.addSupplier(supplier);
            return "redirect:../supplierList";
        } catch (Exception e) {
            map.put("result", "删除失败");
            map.put("href", "../allMeterial");
            e.printStackTrace();
            return "result";
        }
    }
    private int getPages(int limit) {
        if (limit == 0) {
            limit = 10;
        }
        int count = supplierService.getCount();
        int pages = count / limit;
        if (count % limit != 0) {
            pages++;
        }
        return pages;
    }
}
