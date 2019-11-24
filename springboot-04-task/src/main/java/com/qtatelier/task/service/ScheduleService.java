package com.qtatelier.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author JazzXia
 * @create 2019-10-23-14:31
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@Service
public class ScheduleService {

    /**
     * second（秒）,minute（分）,hour（时）,day of month（日）,month（月）,day of week（周）
     * 0 * * * * MON-FRI 周一至周五整秒启动
     */
    @Scheduled(cron = "30 * * * * MON-SAT")
    public void hello(){
        System.out.println("hello......");
         
    }
}
