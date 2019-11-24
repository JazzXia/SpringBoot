package com.qtatelier.springboot.mapper;

import com.qtatelier.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author JazzXia
 * @create 2019-10-20:00
 *
 * 指定这是一个操作数据库的Mapper
 */
//@Mapper 在MybatisConfig或者主配置类上已经加上了批量扫描的注解所以可以不用
public interface DepartmentMapper {

    @Select("select* from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptyId(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{department} where id=#{id}")
    public int updateDept(Department department);
}
