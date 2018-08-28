package com.zuul.bootc.jdktest;

public class TestImpl implements MyInterface ,MyInterface1{

    @Override
    public void test() {
        MyInterface.super.test();
        MyInterface1.super.test();

        System.out.println("override");
    }

    public static void main(String[] args){
        TestImpl t=new TestImpl();
        t.test();
    }
}
