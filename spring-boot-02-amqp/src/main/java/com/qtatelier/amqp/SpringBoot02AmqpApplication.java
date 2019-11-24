package com.qtatelier.amqp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMq自动配置
 *   1、RabbitAutoConfiguration
 *   2、有自动配置了连接工厂ConnectionFactory;
 *   3、RabbitProperties 封装了 RabbitMQ的配置
 *   4、RabbitTemplate：给RabbitMQ发送和接收消息
 *   5、AmqpAdmin:RabbitMQ系统管理功能组件
 *   6、@EnableRabbit + @RabbitListener 监听消息队列的内容
 */

//@MapperScan(value = "com.qtatelier.springboot.mapper")
@EnableRabbit
@SpringBootApplication
public class SpringBoot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02AmqpApplication.class, args);
    }

}
