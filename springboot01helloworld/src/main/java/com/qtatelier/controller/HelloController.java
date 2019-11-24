package com.qtatelier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JazzXia
 * @create 2019-10-16:36
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello.do")
    public String hello(){
        return "Hello World";
    }
}
