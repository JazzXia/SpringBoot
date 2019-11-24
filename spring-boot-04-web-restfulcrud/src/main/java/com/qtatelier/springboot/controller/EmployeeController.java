package com.qtatelier.springboot.controller;

import com.qtatelier.springboot.dao.EmployeeDao;
import com.qtatelier.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author JazzXia
 * @create 2019-10-11:33
 */

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    //查询所有员工返回列表页面
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);

        //thymeleaf默认就会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }


    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(){
        //来到添加页面
        return "emp/add";
    }

}
