package com.zuul.bootc.jdktest.Decorator;

public class HzA extends HzBase {
    @Override
    public void Op() {
        super.Op();
        System.out.println("HzA");
    }
}
