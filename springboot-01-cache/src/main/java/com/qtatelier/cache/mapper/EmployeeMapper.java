package com.qtatelier.cache.mapper;

import com.qtatelier.cache.bean.Department;
import com.qtatelier.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author JazzXia
 * @create 2019-10-9:20
 */
public interface EmployeeMapper {

    @Select("select* from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Delete("delete from employee where id=#{id}")
    public int deleteEmpById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public int insertEmp(Employee employee);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public int updateEmp(Employee employee);

    @Select("select* from employee where lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);
}
