package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
 * @author yangrui
 * 使用lombok
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable{  //实体类实现类表关系映射ORM

    private int  depto;//主键
    private String dname;//部门名称
    private String db_source;//数据库来源

}
