package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 只需要在微服务8001,8002,8003中加入 actuator依赖即可
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_Dashboard_App {

    public void main(String[] args){
        SpringApplication.run(DeptConsumer_Dashboard_App.class, args);
    }
}
