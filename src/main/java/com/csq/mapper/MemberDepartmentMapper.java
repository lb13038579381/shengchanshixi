package com.csq.mapper;

import com.csq.entity.Achievement;
import com.csq.entity.Department;
import com.csq.entity.MemberDepartment;
import com.csq.entity.PageData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDepartmentMapper {
    List<MemberDepartment> getAllMemberDepartment(PageData pageData);

    Integer getCount();

    MemberDepartment getMemberDepartmentById(int id);

    void editMemberDepartment(MemberDepartment memberDepartment);

    void deleteMemberDepartmentById(int id);

    void addMemberDepartment(MemberDepartment memberDepartment);
}
