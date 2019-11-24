package com.qtatelier.springboot.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JazzXia
 * @create 2019-10-20:54
 * 自定义Mybatis的设置
 */
//@org.springframework.context.annotation.Configuration
    //@MapperScan(value = "com.qtatelier.springboot.mapper")或者在主配置类上加这个注解都是一样的效果
@MapperScan(value = "com.qtatelier.springboot.mapper")
@Configuration
public class MyBatisConfig {
    //开启驼峰命名法的命名规则
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
       return new ConfigurationCustomizer(){
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
