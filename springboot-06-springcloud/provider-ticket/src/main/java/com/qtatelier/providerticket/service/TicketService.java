package com.qtatelier.providerticket.service;

import org.springframework.stereotype.Service;

/**
 * @author JazzXia
 * @create 2019-10-23-20:28
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@Service
public class TicketService {

    public String getTicket(){
        System.out.println("8002");
        return "《厉害了，我的妈呀！》";
    }
}
