package com.exer.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-14 16:04
 *
 * 自定义算法
 * 规则:
 *      每个服务器都要分配五次之后,才会使用下一个服务器.
 **/
public class RandomRule_EXER extends AbstractLoadBalancerRule {

    private int total = 0;//当前机器当前调用次数
    private int currentIndex = 0;//当前机器


    public Server choose(ILoadBalancer ib, Object key){
        if (ib == null){
            return null;
        }
        Server server = null;

        while (server == null){
            if (Thread.interrupted()){
                return null;
            }
            List<Server> upList = ib.getReachableServers();
            List<Server> allList = ib.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0){
                return null;
            }

            if (total < 5){
                server = upList.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()){
                    currentIndex = 0;
                }
            }

            if (server == null){
                Thread.yield();
                continue;
            }
            if (server.isAlive()){
                return server;
            }

            server = null;
            Thread.yield();
        }
        return server;
    }


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}
