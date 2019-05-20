package com.zuul.bootd.mizibootd.strategydemo.impl;

import com.zuul.bootd.mizibootd.strategydemo.DataPowerRule;
import org.springframework.stereotype.Component;

@Component("wms")
public class WmsPowerRule implements DataPowerRule {
    @Override
    public String getMysqlWhere() {
        return "WmsWhere";
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
