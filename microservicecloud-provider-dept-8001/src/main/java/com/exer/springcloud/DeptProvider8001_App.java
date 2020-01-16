package com.exer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-13 16:49
 **/
@SpringBootApplication
@EnableEurekaClient//本服务启动后会自动，注册进server中
@EnableDiscoveryClient//服务发现
public class DeptProvider8001_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class,args);
    }

}
