package com.zuul.bootc.jdktest;

public interface MyInterface1 {
     default void test(){
        System.out.println("MyInterface1");
    }
}
