package com.csq.mapper;

import com.csq.entity.Department;
import com.csq.entity.PageData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<Department> getAllDepartment(PageData pageData);

    Integer getCount();

    Department getDepartmentById(int id);

    void editDepartment(Department department);

    void deleteDepartmentById(int id);

    void addDepartment(Department department);
}
