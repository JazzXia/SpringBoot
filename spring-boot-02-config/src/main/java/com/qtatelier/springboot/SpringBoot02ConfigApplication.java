package com.qtatelier.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @**ImportResource**：导入Spring的配置文件，让配置文件里面的内容生效；
 *
 * Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；
 *
 * 想让Spring的配置文件生效，加载进来；@**ImportResource**标注在一个配置类上
 *
 *
 *
 * 我们在主配置文件编写的时候，文件名可以是   application-{profile}.properties/yml
 * 默认使用application.properties的配置；
 *
 * 如果在application.properties中添加spring.profiles.active=dev
 * 那么就会激活配置文件application-dev.properties的配置8082端口
 *
 *
 *
 * yml代码块方式 好处：方便不需要写太多配置文件只需要一个即可
 * server:
 *   port: 8081
 * spring:
 *   profiles:
 *     active: prod
 *
 * ---
 * server:
 *   port: 8083
 * spring:
 *   profiles: dev
 *
 *
 * ---
 *
 * server:
 *   port: 8084
 * spring:
 *   profiles: prod  #指定属于哪个环境
 *
 *
 *    总结 激活指定profile
 *
 * ​	1、在配置文件中指定  spring.profiles.active=dev/或者yml文件
 *
 * ​	2、命令行：
 *
 * ​		java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev；
 *
 * ​		可以直接在测试的时候，配置传入命令行参数
 *【点开Spring的设置选择eidt Configurations---->然后在Enviroment中选择Programs arguments添加 --spring.profiles.active=dev】
 *【或者先打jar包，然后在cmd 打上java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev也是可以的】
 *
 * ​	3、虚拟机参数；
 *【点开Spring的设置选择eidt Configurations---->然后在Enviroment中选择VM options添加 -Dspring.profiles.active=dev】
 * ​也是可以的
 */
/*@ImportResource(locations = {"classpath:beans.xml"})*/
@SpringBootApplication
public class SpringBoot02ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02ConfigApplication.class, args);
    }

}
