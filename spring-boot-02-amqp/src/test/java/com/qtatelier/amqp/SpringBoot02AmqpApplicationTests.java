package com.qtatelier.amqp;

import com.qtatelier.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SpringBoot02AmqpApplicationTests {

    //系统给的
    @Resource
    RabbitTemplate rabbitTemplate;

    //系统的
    @Resource
    AmqpAdmin amqpAdmin;

    //创建交换器exchange
    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("创建完成");
    }


    //创建队列
    @Test
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
        System.out.println("创建完成");
    }


    //创建绑定规则
    @Test
    public void testBinding(){
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                                                        Binding.DestinationType.QUEUE,
                                              "amqpadmin.exchange",
                                             "amqp.haha",
                                             null));
        System.out.println("绑定完成");
        //如果删除解绑可以自己试试
        //amqpAdmin.deleteExchange();
        //amqpAdmin.deleteQueue();
    }
    

    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个;定制消息体内容和消息头
        //rabbitTemplate.send(exchange,routekey,message);

        //object默认当成消息体，这种方式比较常用，只要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(excange,routeKey,object);
/*        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));*/
        //消息已经发送到了，对象呗默认序列化以后发送出去
        //rabbitTemplate.convertAndSend("exchange.direct","qtatlier.news",map);
        rabbitTemplate.convertAndSend("exchange.direct","qtatlier.news",new Book("西游记","吴承恩"));
    }

    //接收数据,如何将数据转为JSON对象
    @Test
    public void testReceive(){
        Object receive = rabbitTemplate.receiveAndConvert("qtatlier.news");
        System.out.println(receive.getClass());
        System.out.println(receive);
    }

    /**
     * 广播
     */

    @Test
    public void testSendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","qtatlier.news",new Book("曹雪芹","罗贯中"));
    }

}
