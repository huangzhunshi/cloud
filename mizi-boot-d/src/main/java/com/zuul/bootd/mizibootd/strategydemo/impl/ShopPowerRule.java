package com.zuul.bootd.mizibootd.strategydemo.impl;

import com.zuul.bootd.mizibootd.strategydemo.DataPowerRule;
import org.springframework.stereotype.Component;

@Component("shop")
public class ShopPowerRule implements DataPowerRule {
    @Override
    public String getMysqlWhere() {
        return "shopMysqlWhere";
    }

    @Override
    public String getPgWhere() {
        return null;
    }

    @Override
    public String getEsWhere() {
        return null;
    }
}
