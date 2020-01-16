package com.exer.springcloud.controller;

import com.exer.springcloud.entities.Dept;
import com.exer.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-13 16:39
 **/
@RestController
public class DeptController {

    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient client;//服务发现

    @PostMapping("/dept/add")
    public Boolean add(Dept dept){
        return service.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){ return service.list(); }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("***********"+ list);

        List<ServiceInstance> serviceList = client.getInstances("MICROSERVICECLOD-DEPT");
        for (ServiceInstance element : serviceList) {
            System.out.println(element.getHost()+"**********"+element.getPort());
        }
        return this.client;
    }

}
