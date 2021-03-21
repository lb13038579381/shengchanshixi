package com.csq.service.impl;

import com.csq.entity.Member;
import com.csq.entity.Meterial;
import com.csq.entity.PageData;
import com.csq.mapper.MemberMapper;
import com.csq.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<Member> getAllMember(PageData pageData) {
        return memberMapper.getAllMember(pageData);
    }

    @Override
    public Integer getCount() {
        return memberMapper.getCount();
    }

    @Override
    public Member getMemberById(int id) {
        return memberMapper.getMemberById(id);
    }

    @Override
    public void editMember(Member member) {
        memberMapper.editMember(member);
    }

    @Override
    public void deleteMemberById(int id) {
        memberMapper.deleteMemberById(id);
    }

    @Override
    public void addMember(Member member) {
        memberMapper.addMember(member);
    }

    @Override
    public Member getMemberByName(String username) {
        return memberMapper.getMemberByName(username);
    }
}
