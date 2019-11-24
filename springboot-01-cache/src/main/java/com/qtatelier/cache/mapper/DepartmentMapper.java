package com.qtatelier.cache.mapper;

import com.qtatelier.cache.bean.Department;
import org.apache.ibatis.annotations.Select;

/**
 * @author JazzXia
 * @create 2019-10-9:20
 */
public interface DepartmentMapper {


    @Select("select * from department where id=#{id}")
   public Department getDeptById(Integer id);
}
