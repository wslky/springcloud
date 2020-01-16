package com.exer.springcloud;

import com.exer.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-13 19:12
 **/
@SpringBootApplication
@EnableEurekaClient
//使用自定义Ribbon策略
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptCustomer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptCustomer80_App.class,args);
    }
}
