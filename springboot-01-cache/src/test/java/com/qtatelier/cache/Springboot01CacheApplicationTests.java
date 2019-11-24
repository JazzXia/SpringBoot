package com.qtatelier.cache;

import com.qtatelier.cache.bean.Employee;
import com.qtatelier.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Resource
    EmployeeMapper employeeMapper;

    //详细看RedisAutoConfiguration系统给的
    @Resource
    StringRedisTemplate stringRedisTemplate; //操作字符串的

    //系统给的
    @Resource
    RedisTemplate redisTemplate; //k-v都是对象的

    //自定义的
    @Resource
    RedisTemplate<Object,Employee> employeeRedisTemplate;

    /**
     * Redis常见的五大数据类型
     *   String(字符串)、List(列表)、Set(集合)、Hash(散列)、ZSet(有序集合)
     *
     * stringRedisTemplate.opsForValue()[String(字符串)]
     * stringRedisTemplate.opsForList()[List(列表)]
     * stringRedisTemplate.opsForSet()[Set(结合)]
     * stringRedisTemplate.opsForHash()[Hash(散列)]
     * stringRedisTemplate.opsForZSet()[ZSet(有序集合)]
     */
    @Test
    public void testRedis01(){
        //给redis中保存数据
        //具体操作详细见www.redis.cn
        //stringRedisTemplate.opsForValue().append("msg","hello");
        //读取Redis中的字符串
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    public void testRedis02(){
        Employee empById = employeeMapper.getEmpById(1);
        //默认如果保存对象，使用jdk序列化机制,序列化后的数据保存到redis中
//redisTemplate.opsForValue().set("emp-01",empById);
        //1、将数据以json的方式保存
         //(1)自己将对象转为JSON
        //(2)redisTemplate默认的序列化规则：下面就是改变默认的序列化规则见MyRedisConfig
        employeeRedisTemplate.opsForValue().set("emp-01",empById);
    }
    

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
         
    }

}
