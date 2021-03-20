package com.csq.controller;

import com.csq.entity.Achievement;
import com.csq.entity.Department;
import com.csq.entity.Member;
import com.csq.entity.PageData;
import com.csq.service.DepartmentService;
import com.csq.utils.DefaultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("departmentController")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("departmentList")
    public String getAll(PageData pageData, Map<String, Object> map) {
        try {
            pageData = DefaultUtils.getPageData(pageData);
            List<Department> departmentList = departmentService.getAllDepartment(pageData);
            //得到总页数
            int pages = getPages(pageData.getLimit());
            pageData.setPages(pages);
            //得到当前页的总条数
            pageData.setCount(departmentList.size());
            //设置当前页
            map.put("pageData", pageData);
            map.put("departmentList", departmentList);
            map.put("location", "departmentList");
            return "department";
        } catch (Exception e) {
            e.printStackTrace();
            return "department";
        }
    }

    @RequestMapping("editDepartment")
    public String editDepartment(Department department, Map<String, Object> map) {
        try {
            departmentService.editDepartment(department);
            map.put("result", "编辑成功");
        } catch (Exception e) {
            map.put("result", "编辑失败");
            e.printStackTrace();
        }
        return "result";
    }

    @RequestMapping("deleteDepartmentById/{id}")
    public String deleteDepartmentById(@PathVariable("id") int id, Map<String, Object> map) {
        try {
            departmentService.deleteDepartmentById(id);
            return "redirect:../departmentList";
        } catch (Exception e) {
            map.put("result", "删除失败");
            map.put("href", "../departmentList");
            e.printStackTrace();
            return "result";
        }
    }

    @RequestMapping("addDepartment")
    public String addDepartment(Department department, Map<String, Object> map) {
        try {
            departmentService.addDepartment(department);
            return "redirect:../departmentList";
        } catch (Exception e) {
            map.put("result", "增加失败");
            map.put("href", "../departmentList");
            e.printStackTrace();
            return "result";
        }
    }

    @RequestMapping("getDepartmentById/{id}")
    public String getDepartmentById(@PathVariable("id") int id, Map<String, Object> map) {
        Department department = null;
        try {
            department = departmentService.getDepartmentById(id);
            map.put("department", department);
            return "department_edit";
        } catch (Exception e) {
            map.put("error", "暂无信息");
            map.put("result", "查询失败");
            map.put("href", "../departmentList");
            return "result";
        }
    }
    private int getPages(int limit) {
        if (limit == 0) {
            limit = 10;
        }
        int count = departmentService.getCount();
        int pages = count / limit;
        if (count % limit != 0) {
            pages++;
        }
        return pages;
    }}
