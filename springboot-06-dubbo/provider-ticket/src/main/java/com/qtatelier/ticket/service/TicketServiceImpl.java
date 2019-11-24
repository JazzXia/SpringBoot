package com.qtatelier.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author JazzXia
 * @create 2019-10-23-18:00
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@Component
@Service//这个Service和之前的Service不一样，这个是Dubbo的Service，所以这是将服务发布到注册中心
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
