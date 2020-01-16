package com.exer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-15 13:25
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class DeptCustomer_DashBoard_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptCustomer_DashBoard_App.class,args);
    }

}
