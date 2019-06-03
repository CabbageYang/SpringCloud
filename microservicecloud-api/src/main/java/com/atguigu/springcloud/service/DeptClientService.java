package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Feign的理解，接口与注解，让微服务面向接口编程
 * 通过Feign只需要定义服务接口且以申明式的方式，简单的实现服务调用
 *
 *出现任何故障都会回到 fallbackFactory中去处理异常
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @RequestMapping(value = "/dept/add",method = RequestMethod.GET)
    public boolean add( Dept deptEntity);

    @RequestMapping(value = "/dept/findById/{deptNo}",method = RequestMethod.GET)
    public Dept findById(int deptNo);

    @RequestMapping(value = "/dept/findAll",method = RequestMethod.GET)
    public List findAll();
}