package com.qtatelier.user;

import com.qtatelier.user.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ConsumerUserApplicationTests {

    @Autowired
    UserServiceImpl userServiceimpl;

    @Test
    public void contextLoads() {
        userServiceimpl.hello();
    }

}
