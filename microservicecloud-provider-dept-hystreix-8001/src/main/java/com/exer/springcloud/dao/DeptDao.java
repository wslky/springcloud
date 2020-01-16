package com.exer.springcloud.dao;

import com.exer.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-13 16:16
 **/
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
