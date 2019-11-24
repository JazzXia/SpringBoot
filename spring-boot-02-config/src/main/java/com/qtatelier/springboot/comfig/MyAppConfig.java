package com.qtatelier.springboot.comfig;

import com.qtatelier.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JazzXia
 * @create 2019-10-8:59
 *
 * @Configuration:指明当前类是一个配置类；就是来替代之前Spring的配置文件
 *
 * 在之前Spring的配置文件中用<bean></bean>标签添加class和id添加组件
 *
 * 而SpringBoot如何配置------将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
 *
 *
 *
 *
 * SpringBoot推荐给容器中添加组件的方式；推荐使用全注解的方式
 *
 * 1、配置类**@Configuration**------>Spring配置文件
 *
 * 2、使用**@Bean**给容器中添加组件
 *
 */

@Configuration
public class MyAppConfig {
    //将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器中添加组建了.....");
         
        return new HelloService();
    }
}
