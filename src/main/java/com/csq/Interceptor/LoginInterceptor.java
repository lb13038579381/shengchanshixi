package com.csq.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        HttpSession session=request.getSession();
        Object ob=session.getAttribute("username");
        if (ob!=null) {
            return true;
        }
        session.setAttribute("preurl",request.getRequestURI());
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        response.sendRedirect("login");
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView model) throws Exception{
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler,Exception ex) throws Exception{
    }

}