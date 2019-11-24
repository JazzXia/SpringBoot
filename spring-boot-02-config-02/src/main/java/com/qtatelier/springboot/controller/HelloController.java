package com.qtatelier.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JazzXia
 * @create 2019-10-10:14
 */

@RestController

public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
