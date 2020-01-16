package com.exer.springcloud.service;

import com.exer.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-15 12:43
 **/
@Component//添加注解
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                //模拟关闭一个Provider服务后,客户端访问该服务,使用备用方法来处理
                return new Dept(id,"降级信息","Provider服务已关闭...");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
