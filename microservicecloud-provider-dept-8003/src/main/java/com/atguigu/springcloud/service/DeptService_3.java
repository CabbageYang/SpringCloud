package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptService_3 {

    public List<Dept> listDept() {
        List<Dept> ps = new ArrayList<>();
        ps.add(new Dept(1,"安全部门","data_1"));
        ps.add(new Dept(2,"财务部门","data_1"));
        ps.add(new Dept(3,"管理部门","data_1"));
        return ps;
    }
}
