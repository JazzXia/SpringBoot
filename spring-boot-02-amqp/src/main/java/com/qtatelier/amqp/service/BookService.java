package com.qtatelier.amqp.service;

import com.qtatelier.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author JazzXia
 * @create 2019-10-22-18:03
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@Service
public class BookService {

    @RabbitListener(queues = "qtatlier.news")
    public Book receive(Book book){
        System.out.println("收到消息！");
        Book book1 = book;
        return book1;
    }

    @RabbitListener(queues = "qtatlier")
    public void receive02(Message message){
        System.out.println(message.getBody());
         System.out.println(message.getMessageProperties());
          
    }
}
