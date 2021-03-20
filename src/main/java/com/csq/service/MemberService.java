package com.csq.service;

import com.csq.entity.Member;
import com.csq.entity.Meterial;
import com.csq.entity.PageData;

import java.util.List;

public interface MemberService {

    List<Member> getAllMember(PageData pageData);

    Integer getCount();

    Member getMeterialById(int id);

    void editMember(Member member);

    void deleteMemberById(int id);

    void addMember(Member member);
}
