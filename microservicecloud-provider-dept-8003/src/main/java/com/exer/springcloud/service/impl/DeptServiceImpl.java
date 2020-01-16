package com.exer.springcloud.service.impl;

import com.exer.springcloud.service.DeptService;
import com.exer.springcloud.dao.DeptDao;
import com.exer.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lkycccc11@163.com
 * @create: 2020-01-13 16:35
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }
}
