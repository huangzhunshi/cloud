package com.zuul.bootc.jdktest;

public interface MyInterface {
     default void test(){
        System.out.println("MyInterface");
    }
}
