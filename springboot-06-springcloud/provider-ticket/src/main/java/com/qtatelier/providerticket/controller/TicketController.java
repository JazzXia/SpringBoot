package com.qtatelier.providerticket.controller;

import com.qtatelier.providerticket.service.TicketService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-10-23-20:29
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@RestController
public class TicketController {

    @Resource
    TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket(){
        return ticketService.getTicket();
    }
}
