package com.qtatelier.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qtatelier.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author JazzXia
 * @create 2019-10-23-19:16
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@Service//这个是spring的Service
public class UserServiceImpl implements UserService {

    @Reference
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了:"+ticket);
    }
}