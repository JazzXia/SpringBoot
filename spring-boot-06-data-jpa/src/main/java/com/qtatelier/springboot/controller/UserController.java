package com.qtatelier.springboot.controller;

import com.qtatelier.springboot.entity.User;
import com.qtatelier.springboot.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-10-13:08
 */
@RestController
public class UserController {

    @Resource(name="userRepository")
    UserRepository userRepository;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        //在SpringBoot2.x中findOne和SpringBoot1.5x是不一样的，所以用这种方法解决。
        //在SpringBoot中还存在getOne()这种方法，虽然不知道有啥作用，但是可以去查API

        User user = userRepository.findById(id).orElse(null);
        return user;
    }


    @PostMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}