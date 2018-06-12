package com.zuul.bootc;

import java.util.Date;

public class Test {
    long size = 100000L;
    public static void main(String[] args) {
        Test t = new Test();
        t.test1();

        t.test2();


    }

    long func1(long i) throws Exception{
        if(i == 0){
            throw new Exception("abc");
        }
        return i-1;
    }

    long func2(long i){
        if(i == 0){
            return i + 1;
        }
        return i -1;
    }

    void test1(){
        Date begin = new Date();
        long total = 0;
        for(long i = 1; i < size; ++i){
            try {
                total += func1(0);
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
        Date end = new Date();
        //System.out.println(total);
        System.out.println("test1 time:" + (end.getTime() - begin.getTime()));

    }

    void test2(){
        Date begin = new Date();
        long total = 0;
        for(long i = 1; i < size; ++i){
            total += func2(i);
        }
        Date end = new Date();
        //System.out.println(total);
        System.out.println("test2 time:" + (end.getTime() - begin.getTime()));
    }
}
