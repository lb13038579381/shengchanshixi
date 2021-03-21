package com.csq.controller;

import com.csq.entity.Department;
import com.csq.entity.Member;
import com.csq.entity.Meterial;
import com.csq.entity.PageData;
import com.csq.service.MemberService;
import com.csq.utils.DefaultUtils;
import com.csq.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("memberController")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("memberList")
    public String getAll(PageData pageData, Map<String, Object> map) {
        try {
            pageData = DefaultUtils.getPageData(pageData);
            List<Member> memberList = memberService.getAllMember(pageData);
            //得到总页数
            int pages = getPages(pageData.getLimit());
            pageData.setPages(pages);
            //得到当前页的总条数
            pageData.setCount(memberList.size());
            //设置当前页
            map.put("pageData", pageData);
            map.put("memberList", memberList);
            map.put("location", "memberList");
            return "member";
        } catch (Exception e) {
            e.printStackTrace();
            return "member";
        }
    }

    @RequestMapping("editMember")
    public String editMember(Member member, Map<String, Object> map) {
        try {
            memberService.editMember(member);
            map.put("result", "编辑成功");
            map.put("href","memberList");
        } catch (Exception e) {
            map.put("result", "编辑失败");
            e.printStackTrace();
        }
        return "result";
    }

    @RequestMapping("deleteMemberById/{id}")
    public String deleteMemberById(@PathVariable("id") int id, Map<String, Object> map) {
        try {
            memberService.deleteMemberById(id);
            return "redirect:../memberList";
        } catch (Exception e) {
            map.put("result", "删除失败");
            map.put("href", "../memberList");
            e.printStackTrace();
            return "result";
        }
    }

    @RequestMapping("addMemberPre")
    public String addMemberPre(Member member) {
        return "add_member";
    }
    @RequestMapping("addMember")
    public String addMember(Member member, Map<String, Object> map) {
        try {
            member.setPassword(MD5Utils.toMD5(member.getPassword()));
            memberService.addMember(member);
            map.put("result","增加成功");
            return "redirect:memberList";
        } catch (Exception e) {
            map.put("result", "增加失败");
            map.put("href", "memberList");
            e.printStackTrace();
        }
        return "result";
    }


    @RequestMapping("getMemberById/{id}")
    public String getMemberById(@PathVariable("id") int id, Map<String, Object> map) {
        Member member = null;
        try {
            member = memberService.getMemberById(id);
            map.put("member", member);
            return "member_edit";
        } catch (Exception e) {
            map.put("error", "暂无信息");
            map.put("result", "查询失败");
            map.put("href", "../memberList");
            return "result";
        }
    }

    private int getPages(int limit) {
        if (limit == 0) {
            limit = 10;
        }
        int count = memberService.getCount();
        int pages = count / limit;
        if (count % limit != 0) {
            pages++;
        }
        return pages;
    }
}
