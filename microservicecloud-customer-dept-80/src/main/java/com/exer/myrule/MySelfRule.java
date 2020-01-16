package com.exer.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-14 15:49
 **/
/*
    不能讲该类放在主启动类的包或子包下
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule_EXER();
    }

}
