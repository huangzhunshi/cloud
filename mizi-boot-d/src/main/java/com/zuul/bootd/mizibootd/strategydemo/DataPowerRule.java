package com.zuul.bootd.mizibootd.strategydemo;

public interface DataPowerRule {

    String getMysqlWhere();

    String getPgWhere();

    String getEsWhere();
}
