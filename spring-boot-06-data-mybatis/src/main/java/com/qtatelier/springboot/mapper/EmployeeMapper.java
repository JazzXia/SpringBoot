package com.qtatelier.springboot.mapper;

import com.qtatelier.springboot.bean.Employee;

/**
 * @author JazzXia
 * @create 2019-10-9:12
 */
//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
