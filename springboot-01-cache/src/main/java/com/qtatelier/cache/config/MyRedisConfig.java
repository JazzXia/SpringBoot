package com.qtatelier.cache.config;

import com.qtatelier.cache.bean.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author JazzXia
 * @create 2019-10-22-8:02
 * @email jazzxiaw@qq.com
 * @since 2019
 *
 * @description 改变系统默认的序列化规则
 */

@Configuration
public class MyRedisConfig {

    //对于redis直接存数有效如：test里面的方法
    @Bean
    public RedisTemplate<Object, Employee> empredisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        //将其默认序列化转为JSON格式
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
}
