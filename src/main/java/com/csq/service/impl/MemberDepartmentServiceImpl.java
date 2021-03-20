package com.csq.service.impl;

import com.csq.entity.MemberDepartment;
import com.csq.entity.PageData;
import com.csq.mapper.MemberDepartmentMapper;
import com.csq.service.MemberDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberDepartmentServiceImpl implements MemberDepartmentService {
    @Autowired
    MemberDepartmentMapper memberDepartmentMapper;
    @Override
    public List<MemberDepartment> getAllMemberDepartment(PageData pageData) {
        return memberDepartmentMapper.getAllMemberDepartment(pageData);
    }

    @Override
    public Integer getCount() {
        return memberDepartmentMapper.getCount();
    }

    @Override
    public MemberDepartment getMemberDepartmentById(int id) {
        return memberDepartmentMapper.getMemberDepartmentById(id);
    }

    @Override
    public void editMemberDepartment(MemberDepartment memberDepartment) {
        memberDepartmentMapper.editMemberDepartment(memberDepartment);
    }

    @Override
    public void deleteMemberDepartmentById(int id) {
        memberDepartmentMapper.deleteMemberDepartmentById(id);
    }

    @Override
    public void addMemberDepartment(MemberDepartment memberDepartment) {
        memberDepartmentMapper.addMemberDepartment(memberDepartment);
    }
}
