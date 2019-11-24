package com.qtatelier.springboot.controller;

import com.qtatelier.springboot.bean.Department;
import com.qtatelier.springboot.bean.Employee;
import com.qtatelier.springboot.mapper.DepartmentMapper;
import com.qtatelier.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-10-20:14
 */
@RestController
public class DeptController {

    @Resource
    DepartmentMapper departmentMapper;

    @Resource
    EmployeeMapper employeeMapper;


    //@PathVariable将url中的占位符xxx绑定到参数也就是将url中的/dept/{id},里面的id绑定到下面
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }


    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }


    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}
