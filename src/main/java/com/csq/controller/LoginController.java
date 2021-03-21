package com.csq.controller;

import com.csq.entity.Member;
import com.csq.service.MemberService;
import com.csq.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("loginController")
public class LoginController {
    @Autowired
    MemberService memberService;

    @RequestMapping("login")
    public String login(Map<String,String> map ,String username, String password, HttpServletRequest request, HttpServletResponse response) {
        Member member = memberService.getMemberByName(username);
        if (member == null) {
            map.put("result", "没有该用户");
            return "redirect:/login.html";
        }
        String pwd = MD5Utils.toMD5(password);
        if (pwd.equals(member.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            return "redirect:/index.html";
        } else {
            map.put("result", "密码错误");
            return "redirect:/login.html";
        }
    }
}
