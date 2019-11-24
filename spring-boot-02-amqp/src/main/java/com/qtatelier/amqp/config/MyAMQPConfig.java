package com.qtatelier.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JazzXia
 * @create 2019-10-22-13:13
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@Configuration
public class MyAMQPConfig {

    //在新版的SpringBoot2.2.x中规定了Jackson2JsonMessageConverter这个类，不再仅仅只是MessageConverter的一个方法了
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
