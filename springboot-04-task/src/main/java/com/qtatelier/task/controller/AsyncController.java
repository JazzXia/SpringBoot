package com.qtatelier.task.controller;

import com.qtatelier.task.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-10-23-14:25
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@RestController
public class AsyncController {

    @Resource
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello(){
        asyncService.hello();
        return "success";
    }
}
