package com.qtatelier.springboot.controller;

import com.qtatelier.starter.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-10-16:28
 */
@RestController
public class HelloController {
    @Resource
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHelloqtatelier("强盛");

    }
}
