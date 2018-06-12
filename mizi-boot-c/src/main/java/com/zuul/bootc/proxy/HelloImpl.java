package com.zuul.bootc.proxy;

public class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("sayHello");
    }
}
