package com.atguigu.springcloud.controller;

import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
/**
 * 引入Hystrix熔断机制
 * 一旦调用服务失败并抛出了错误，会自动调用@HysrixCommand标注好的fallbackMethod调用类中的方法。
 * 但是此时业务方法与异常处理耦合在一起，需要将其解耦分离(回到api中的service层)，spring中的AOP面向切面编程
 */
@RestController  //返回json串
public class DeptController {

    @Autowired
    private DeptService service;

    @RequestMapping(value="/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){

        Dept dept =  service.get(id);
        if(dept == null){
            throw new RuntimeException("该ID：" + id + "没用对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id")  int id){
        return new Dept().setDepto(id).setDname("该ID：" +id+ "没用对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");

    }
   /* @RequestMapping(value="/dept/list", method = RequestMethod.GET)
    public List<Dept> list(){
        return service.list();
    }*/
}
