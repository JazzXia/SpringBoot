package com.qtatelier.springboot.repository;

import com.qtatelier.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author JazzXia
 * @create 2019-10-10:24
 */
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {
}

