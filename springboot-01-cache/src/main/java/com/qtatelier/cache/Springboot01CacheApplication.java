package com.qtatelier.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 一、搭建基本环境
 * //1.导入数据库文件创建数据库department和employee表
 * //2.创建javaBean封装数据
 * //3.整合Mybatis操作数据库
 *     1.配置数据源信息
 *     2.使用注解版的Mybatis
 *        1)MapperScan
 * 二、快速体验缓存
 *     步骤:
 *        1、开启基于注解的缓存
 *        2、标注缓存注解即可
 *          @Cacheable
 *          @CacheEvict
 *          @CachePut
 *默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache来进行缓存的;
 * 将数据保存在ConcurrentMap<Object,Object>
 * 开发中使用缓存中间件：redis、memcached、ehcache;
 * spring默认开启SimpleCacheConfiguration配置类
 *
 * 三、整合Redis
 * Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 *  1、安装redis：使用docker；
 *  2、引入redis的starter
 *  3、配置redis
 *  4、测试缓存
 *       原理：CaccheManager==Cache 缓存组件来实际给缓存中存取数据
 *       1)、引入redis的starter，容器中保存的是RedisCacheManager
 *       2）、RedisCacheManager帮我们创建RedisCache来作为缓存组件；redisCache通过操作redis缓存数据的
 *       3)、默认保存数据 k-v 都是Object；利用序列化保存的;如何保存为json
 *              1、引入了redis的starter，cacheManager变为RedisCacheManager;
 *              2、默认创建的redisCacheManager操作redis的时候使用的是 RedisTemplate<Object,Object>
 *              3、RedisTemplate<Object,Object>默认使用jdk的序列化机制
 *       4)、自定义CacheManager
 */

@MapperScan("com.qtatelier.cache.mapper")
@SpringBootApplication
@EnableCaching
public class Springboot01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01CacheApplication.class, args);
    }

}
