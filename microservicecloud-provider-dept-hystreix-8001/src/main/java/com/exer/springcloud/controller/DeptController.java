package com.exer.springcloud.controller;

import com.exer.springcloud.entities.Dept;
import com.exer.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    //一旦该方法出错会调用processHystrix_Get()方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        if (service.get(id) == null){
            throw new NullPointerException();
        }
        return service.get(id);
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept(id,"没有该信息","信息不存在");
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
