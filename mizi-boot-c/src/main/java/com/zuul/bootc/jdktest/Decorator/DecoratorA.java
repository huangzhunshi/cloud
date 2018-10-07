package com.zuul.bootc.jdktest.Decorator;

public class DecoratorA  extends Decorator{

    @Override
    public void op() {
        super.op();
        System.out.println("D-A");
    }
}
