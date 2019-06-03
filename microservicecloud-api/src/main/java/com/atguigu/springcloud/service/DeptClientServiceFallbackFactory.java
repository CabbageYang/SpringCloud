package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *根据已有的DeptClientServiec接口，一个实现了FallbackFactory接口类的DeptClientServiceFallbackFactory
 * 这里FallbackFactory继承了DeptClientService接口
 */

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {

            @Override
            public boolean add(Dept deptEntity) {
                return false;
            }

            @Override
            public Dept findById(int depto) {
                return new Dept().setDepto( depto)
                        .setDname("该deptNo没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已经关闭")
                        .setDb_source("没有这个数据库");
            }

            @Override
            public List findAll() {
                return null;
            }
        };
    }
}