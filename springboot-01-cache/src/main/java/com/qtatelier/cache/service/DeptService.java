package com.qtatelier.cache.service;

import com.qtatelier.cache.bean.Department;
import com.qtatelier.cache.mapper.DepartmentMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-10-22-9:35
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@CacheConfig(cacheNames = "department",cacheManager ="MycacheManager")
@Service
public class DeptService {

    @Resource
    DepartmentMapper departmentMapper;

    @Cacheable
    public Department getDeptById(Integer id){
        System.out.println("查询部门" + id);
         
       Department department =  departmentMapper.getDeptById(id);
       return department;
    }
}
