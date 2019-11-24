package com.qtatelier.cache.service;

import com.qtatelier.cache.bean.Employee;
import com.qtatelier.cache.mapper.EmployeeMapper;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-10-9:55
 */
@CacheConfig(cacheNames = "emp",cacheManager ="MycacheManager")//抽取缓存的公共配置
@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;


    /**
     *
     * @CacheConfig(cacheNames = "emp")这个参数写上，那么下面所有的value和cacheNames都可以去掉了
     *
     *
     * @Cacheable将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，
     * 不用调用方法
     *
     * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字
     * @Cacheable的几个属性：
     *     cacheNames/value：指定缓存的名字；将方法的返回结果放在哪个缓存中，
     *                       是数组的方式，可以指定多个缓存
     *     key：缓存数据使用的key：可以用它来指定。默认是使用方法参数的值  1-方法的返回值
     *             编写SpEL表达式;#id;参数id的值 #a0/#p0:表示第一个参数  #root.args[0]
     *             @Cacheable(cacheNames = {"emp"}，#root.args[0])
     *
     *             key = "#root.methodName+'['+#id+']'" getEmp[2]
     *     keyGenerator: key的生成器；可以自己定义key的生成器的组件id
     *          key/keyGenerator：二选一使用config包内
     *          keyGenerator = "myKeyGenerator"这个是自己定义的见
     *
     *     cacheManager:指定缓存管理器;或者cacheResolver指定的缓存解析器
     *     cacheResolver/cacheManager二选一
     *     conditon:指定符合条件的情况下才缓存
     *
     *     condition = "#a0>1",unless = "#a0==2"
     *
     *     unless:否定缓存；而unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *             unless = "#result == null"
     *             unless = "#a0==2" 如果第一个参数的值是2，结果不缓存
     *     sync:是否使用异步模式
     *          将其调为true，unless不支持
     *
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"})
    @Transactional
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
         Employee employee = employeeMapper.getEmpById(id);
         return employee;
    }

    /**
     * @CachePut既调用方法，又更新缓存数据;同步更新缓存
     * 修改了数据库的某个数据，同时更新缓存；
     * 运行时机：
     *    1、先调用目标方法
     *    2、将目标方法的结果缓存起来
     *
     * 测试步骤：
     *  1、查询一号员工,查到的结果会放在缓存中
     *           key：1 value：gender=1
     *  2、以后查询还是之前的结果
     *  3、更新一号员工[gender=0]
     *          将方法的返回值也放进缓存了；
     *          key传入的Employee对象，返回的也是employee对象
     *  4、查询1号员工
     *        应该是更新后的员工；
     *        key = "#employee.id":使用传入的参数的员工id；
     *        key = "#result.id"：使用返回后的id
     *        上述都行
     *              @Cacheable的key是不能用#result取出返回结果
     *              因为这取决于两个注解的运行时机，
     *              @Cacheable是在返回之前运行的没有result
     *              @CachePut是在返回之后运行的所以可以使用
     *        为什么没更新【1号员工没有在缓存中更新】
     */
    @CachePut(/*value = "emp",*/key = "#result.id")
    @Transactional
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存清除
     * 通过key来指定要清除的数据 @CacheEvict(value = "emp",key = "#id")
     *  allEntries = true:指定清除缓存中所有的数据
     *
     *  beforeInvocation = false:缓存的清除是否在方法之前进行
     *                默认是false在方法执行之后进行
     *                适用场景：如果在方法执行之后出错了缓存不会清空，
     *                         如果在方法执行之前出错了缓存会清空
     * @param id
     * @return
     */
    @CacheEvict(value = "emp",key = "#id")
    @Transactional
    public int deleteEmp(Integer id){
        System.out.println("deleteEmp:"+id);
        int i = employeeMapper.deleteEmpById(id);
        return i;
    }


    //@Caching 定义复杂的缓存规则
    //在这里每次查询都还是从数据库中查询
    //因为这里将ById和ByEmail查询都缓存了，缓存是因为是在BylastName之后运行的缓存
    @Caching(
            cacheable = {
                    @Cacheable(/*value="emp",*/key = "#lastName")
            },
            put = {
                    @CachePut(/*value="emp",*/key = "#result.id"),
                    @CachePut(/*value = "emp",*/key = "#result.email")
            }
    )
    @Transactional
    public Employee getEmpByLastName(String lastName){
        System.out.println("lastName查询");
         
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        return emp;
    }
}
















/**
 *
 *      * 原理：
 *      *    1、自动配置类：CacheAutoConfiguration
 *      *    2、缓存配置类
 *      *    org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
 *      *    org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
 *      *    org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration【导了EhCache才配置】
 *      *    org.springframework.boot.autoconfigure.cache.HazeCacheConfiguration
 *      *    org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
 *      *    org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
 *      *    org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration【导了Redis才配置】
 *      *    org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
 *      *    org.springframework.boot.autoconfigure.cache.GeuavaCacheConfiguration
 *      *    org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration【默认】
 *      *    org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
 *      *    3、哪个配置类默认生效：SimpleCacheConfiguration；
 *      *    4、给容器中注册了一个CacheManager：ConcurrentMapCacheManager
 *      *    5、可以获取和创建ConcurrentMapCache类型的缓存组件；他的作用将数据保存在ConcurrentMap
 *      *
 *      *    运行流程：
 *      *    @Cacheable
 *      *    1、方法运行之前，先去查询Cache（缓存组件），按照cacheNames指定的名字获取；
 *      *       (CacheManager先获取相应的缓存)，第一次获取缓存如果没有Cache组件会自动创建
 *      *    2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数；
 *      *       key是按照某种策略生成的；默认是使用keyGenerator生成的。
 *      *    3、没有查到缓存就调用目标方法；
 *      *    4、将目标方法返回的结构，放进缓存中使用put方法
 *      *
 *      *      @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，如果没有
 *      *      就运行方法并将结果放入缓存
 *      *
 *      *      核心：
 *      *         1）、使用CacheManager【ConcurrentMapCache】按照名字得到Cache组件
 *      *         2)、key使用keyGenerator生成的，默认是SimpleGenerator生成的
 */
