package com.qtatelier.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author JazzXia
 * @create 2019-10-10:04
 *
 * 登录检查，拦截器
 */	
public class LoginHandlerInterceptor implements HandlerInterceptor {
   //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user==null){
            //未登录返回登录页面
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //登录就放行
            return true;
        }

    }
}
