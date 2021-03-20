package com.csq.service;


import com.csq.entity.Department;
import com.csq.entity.PageData;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment(PageData pageData);

    Integer getCount();

    Department getDepartmentById(int id);

    void editDepartment(Department department);

    void deleteDepartmentById(int id);

    void addDepartment(Department department);
}
