package com.exer.springcloud.controller;

import com.exer.springcloud.entities.Dept;
import com.exer.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-13 18:37
 **/
@RestController
public class DeptController_Customer {

    @Autowired
    private DeptClientService service;

    @GetMapping("/customer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){
        return service.get(id);
    }

    @GetMapping("/customer/dept/list")
    public List<Dept> list(){
        return service.list();
    }

    @PostMapping("/customer/dept/add")
    public boolean add(Dept dept){
        return service.add(dept);
    }


}
