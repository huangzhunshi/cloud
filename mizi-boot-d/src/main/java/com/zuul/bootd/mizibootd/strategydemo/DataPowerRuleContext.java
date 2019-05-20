package com.zuul.bootd.mizibootd.strategydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DataPowerRuleContext {

    @Autowired
    private final Map<String,DataPowerRule> dataPowerRuleMap=new ConcurrentHashMap<>();


    public DataPowerRuleContext(Map<String, DataPowerRule> dataPowerRuleMap) {
        this.dataPowerRuleMap.clear();
        dataPowerRuleMap.forEach((k, v)-> this.dataPowerRuleMap.put(k, v));
    }

    public String getResource(String ruleName) {
        return dataPowerRuleMap.get(ruleName).getMysqlWhere();

    }
}
