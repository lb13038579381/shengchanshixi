package com.csq.mapper;

import com.csq.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> getAllMember(PageData pageData);

    Integer getCount();

    Member getMemberById(int id);

    void editMember(Member member);

    void deleteMemberById(int id);

    void addMember(Member member);
}
