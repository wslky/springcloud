package com.exer.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-16 00:50
 *
 * 读取配置中心文件
 **/

@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.server-url.defaultZone}")
    private String eurekaService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String getConfig(){
        String str = "applicationName: " + applicationName+"\t"+"eurekaService: "+eurekaService+"\t"+"port: "+port;
        return str;
    }




}
