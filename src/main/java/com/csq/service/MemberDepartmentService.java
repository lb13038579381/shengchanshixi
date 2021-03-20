package com.csq.service;

import com.csq.entity.MemberDepartment;
import com.csq.entity.PageData;

import java.util.List;

public interface MemberDepartmentService {
    List<MemberDepartment> getAllMemberDepartment(PageData pageData);

    Integer getCount();

    MemberDepartment getMemberDepartmentById(int id);

    void editMemberDepartment(MemberDepartment memberDepartment);

    void deleteMemberDepartmentById(int id);

    void addMemberDepartment(MemberDepartment memberDepartment);
}
