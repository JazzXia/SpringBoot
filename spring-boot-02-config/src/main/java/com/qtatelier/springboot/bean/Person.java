package com.qtatelier.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author JazzXia
 * @create 2019-10-20:15
 *
 * 将配置文件中的每一个属性的值，映射到这个组件中
 *
 * @ConfigurationProperties告诉SpringBoot将本类中的所有属性和配置文件中相关配置进行绑定
 *       prefix = "person":配置文件中哪个下面的所有属性进行一一映射
 *
 *       只有这个组件是容器中的组件，才能使用容器中@ConfigurationProperties的功能
 *
 *
 *       当然获取值的方式不止一种第一种就是@ConfigurationProperties(prefix = "person")这个强大的注解
 *       第二种还是Spring时候的@Value()这个注解二者选其一就可以了。
 *
 *                  两种取值比较
 * |                      | @ConfigurationProperties | @Value     |
 * | -------------------- | ------------------------ | ---------- |
 * | 功能                 | 批量注入配置文件中的属性   | 一个个指定 |
 * | 松散绑定（松散语法）  | 支持                     | 不支持     |
 * | SpEL                | 不支持                   | 支持       |
 * | JSR303数据校验      | 支持                     | 不支持     |
 * | 复杂类型封装        | 支持                     | 不支持     |
 *
 *     配置文件yml还是properties他们都能获取到值；
 *     如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；
 *
 *     如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；
 *
 *  @ConfigurationProperties(prefix = "person")默认从全局配置文件中获取值
 *
 */
//@PropertySource(value = {"classpath:person.properties"}) 这个是从指定配置文件中读取相关配置，不需要从主配置文件中获取相关值
@Component
@ConfigurationProperties(prefix = "person")
//@Validated 校验功能
public class Person {

    /**
     * <bean class="Person">
     *      <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
     * </bean>
     *
     */

    /*@Email 邮箱校验的注解*/
//    @Value("${person.last-name}")
    private String lastName;
    /*@Value("#{11*2}")*/
    private Integer age;
    /*@Value("true")*/
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> list;
    private Dog dog;

    public Person() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }


}
