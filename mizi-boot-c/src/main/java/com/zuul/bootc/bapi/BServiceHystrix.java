package com.zuul.bootc.bapi;

import org.springframework.stereotype.Component;

@Component
public class BServiceHystrix implements BServiceApi {
    @Override
    public String test() {
        return "服务调用失败!!!";
    }
}
