package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 引入cloud新组建，分两部走：
 *      1）新增maven依赖，注明服务端还是客户端
 *      2）再在主启动类上标注新组建技术的相关标注标签
 */
@SpringBootApplication
@EnableEurekaServer// EurekaServer服务端启动类，接受其他服务注册进来
public class EurekaServer7001_App {

    public static void main(String[] args){
        SpringApplication.run(EurekaServer7001_App.class,args);
    }
}
