package com.qtatelier.cache.cotroller;

import com.qtatelier.cache.bean.Employee;
import com.qtatelier.cache.service.EmployeeService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-10-10:01
 */
@RestController
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {

        Employee emp = employeeService.getEmp(id);

        return emp;
    }


    @GetMapping("/emp")
    public Employee updateEmployee(Employee employee) {

        Employee emp = employeeService.updateEmp(employee);

        return emp;
    }

    @GetMapping("/delete")
    public int deleteEmployee(Integer id) {
        int i = employeeService.deleteEmp(id);
        return i;
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmployeeByName(@PathVariable("lastName") String lastName){
        Employee emp = employeeService.getEmpByLastName(lastName);
        return emp;
    }
}
