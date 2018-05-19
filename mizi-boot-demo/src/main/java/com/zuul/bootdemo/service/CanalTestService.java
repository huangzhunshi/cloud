package com.zuul.bootdemo.service;

import com.zuul.bootdemo.domain.entity.CanalTestDO;

public interface CanalTestService  {
    /**
     * 根据id获取实体
     * @param id
     * @return
     */
     CanalTestDO getCanalTestByid(Integer id);
}
