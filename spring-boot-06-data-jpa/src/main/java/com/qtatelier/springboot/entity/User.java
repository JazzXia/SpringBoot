package com.qtatelier.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author JazzXia
 * @create 2019-10-10:12
 */
//使用JPA注解配置映射关系
//告诉JPA这是一个实体类（和数据表映射的类）
@Entity
//@Table指定和那个数据表对应，如果省略默认表名就是类名小写
@Table(name = "tbl_user")
public class User implements Serializable {

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column//这是和数据表对应的一个列也可以自己随便起名,也可以加上长度@Column(name = "xxx",length=50)
    private String lastName;
    @Column//如果什么都没写，默认列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLastName(), getEmail());
    }
}
