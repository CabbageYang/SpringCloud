package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_1 {

    @Autowired
    private DeptService_3 deptService_1;

    @RequestMapping(value="/dept/list1", method = RequestMethod.GET)
    public Object list(){
        List<Dept> ps = deptService_1.listDept();
        return ps;
    }
}
