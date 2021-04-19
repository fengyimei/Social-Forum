package com.baizhi.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            Object username = request.getSession().getAttribute("username");
            if(username == null){
                request.getSession().setAttribute("msg2","未登录或登录信息已失效，请重新登陆");
                //redirectAttributes.addFlashAttribute("msg2","未登录或登录信息已失效，请重新登陆")
                response.sendRedirect("/index");
                return false;
            }
            return true;
    }
}
