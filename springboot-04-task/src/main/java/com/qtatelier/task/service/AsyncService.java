package com.qtatelier.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author JazzXia
 * @create 2019-10-23-14:21
 * @email jazzxiaw@qq.com
 * @since 2019
 */

@Service
public class AsyncService {


    //告诉Spring的异步的
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中...");
         

    }
}
