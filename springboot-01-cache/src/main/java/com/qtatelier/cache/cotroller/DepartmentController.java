package com.qtatelier.cache.cotroller;

import com.qtatelier.cache.bean.Department;
import com.qtatelier.cache.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author JazzXia
 * @create 2019-10-22-9:42
 * @email jazzxiaw@qq.com
 * @since 2019
 */
@RestController
public class DepartmentController {

    @Resource
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        Department deptById = deptService.getDeptById(id);
            return deptById;
    }
}
