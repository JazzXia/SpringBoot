package com.qtatelier.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author JazzXia
 * @create 2019-10-16:04
 */
@Controller
public class HelloController {


    //如何定位到静态文件中的index.html
    //方法一如下  方法二可以在config文件中使用视图解析器定位  方法三看MyMvcConfig
    //@RequestMapping({"","/","/index.html"})
    //templates这个是thymeleaf的模板引擎的路径自动转向
   // public String index(){
    //    return "login";
    //}


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    //查出一些数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //classpath:/templates/success.html templates这个是thymeleaf的模板引擎的路径
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
