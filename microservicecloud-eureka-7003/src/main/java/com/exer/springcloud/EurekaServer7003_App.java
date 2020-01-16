package com.exer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-14 12:55
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003_App {

    public static void main(String[] args) { SpringApplication.run(EurekaServer7003_App.class,args); }
}
