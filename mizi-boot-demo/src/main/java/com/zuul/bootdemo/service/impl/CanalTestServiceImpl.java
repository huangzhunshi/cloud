package com.zuul.bootdemo.service.impl;

import com.zuul.bootdemo.dao.CanalTestDAO;
import com.zuul.bootdemo.domain.entity.CanalTestDO;
import com.zuul.bootdemo.service.CanalTestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanalTestServiceImpl implements CanalTestService {
    @Autowired
    private CanalTestDAO canalTestDAO;

    public CanalTestDO getCanalTestByid(Integer id){
         canalTestDAO.deleteByPrimaryKey(id);
         return null;
    }
}
