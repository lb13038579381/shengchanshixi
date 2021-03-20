package com.csq.service.impl;

import com.csq.entity.Department;
import com.csq.entity.PageData;
import com.csq.mapper.DepartmentMapper;
import com.csq.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartment(PageData pageData) {
        return departmentMapper.getAllDepartment(pageData);
    }

    @Override
    public Integer getCount() {
        return departmentMapper.getCount();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentMapper.getDepartmentById(id);
    }

    @Override
    public void editDepartment(Department department) {
        departmentMapper.editDepartment(department);
    }

    @Override
    public void deleteDepartmentById(int id) {
        departmentMapper.deleteDepartmentById(id);
    }

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }
}
