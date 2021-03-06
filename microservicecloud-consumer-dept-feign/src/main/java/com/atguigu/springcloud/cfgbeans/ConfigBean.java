package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    /**
     * 配置RestTemplate
     * 通过RestTemplate调用提供者服务 ，发送rest请求
     * 提供了多种访问http服务的方法，
     * 针对于访问rest服务<strong>客户端</strong>的调用的模板类
     * @return
     */
    @Bean
    @LoadBalanced   //Springboot Ribbon是Netfix Ribbon实现的一套客户端 负载均衡工具，，，获得rest时加入Ribbon的配置
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        //用我们选择的随机算法,如果没有，这使用默认的轮询算法
        return new RandomRule();
    }
}
