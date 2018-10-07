package com.zuul.bootc.jdktest.Decorator;

public class DecoratorB  extends Decorator{

    @Override
    public void op() {
        super.op();
        System.out.println("D-B");
    }
}
