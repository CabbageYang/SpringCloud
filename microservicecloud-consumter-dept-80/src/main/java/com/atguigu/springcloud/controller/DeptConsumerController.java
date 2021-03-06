package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";//通过微服务名称来访问

    @Autowired
    private RestTemplate restTemplate;

 /*   @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept){
        //三个参数 url,requestMap,ResponseBean.class
        return restTemplate.postForObject(
                REST_URL_PREFIX + "/dept/add",dept ,
                 Boolean.class);
    }
    @RequestMapping("/consumer/dept/findById/{deptNo}")
    public Dept findById(Long deptNo){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/findById/"+deptNo,
                Dept.class);
    }
*/
    @RequestMapping("/consumer/dept/findAll")
    public List findAll(){
        //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/list1",
                List.class);
    }
}
