package com.qtatelier.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author JazzXia
 * @create 2019-10-9:25
 */
@Controller
public class LoginCotroller {

    @PostMapping(value="/user/login")
   //老版的Spring @RequestMapping(value="/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功,防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登录失败
            map.put("msg","用户名密码错误");
            return "login.html";
        }


    }
}
