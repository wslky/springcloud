package com.exer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-13 19:12
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DeptCustomer80_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptCustomer80_Feign_App.class,args);
    }
}
