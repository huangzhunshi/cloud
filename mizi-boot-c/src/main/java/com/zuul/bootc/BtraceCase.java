package com.zuul.bootc;


import java.util.Random;

/**
 * 性能检测工具
 */
public class BtraceCase {
    public static Random random = new Random();
    public int size;

    public static void main(String[] args) throws Exception {
        new BtraceCase().run();
    }

    public void run() throws Exception {
        while (true) {
           int b= add(random.nextInt(10), random.nextInt(10));
           System.out.println(b);
        }
    }

    public int add(int a, int b) throws Exception {
        Thread.sleep(random.nextInt(10) * 100);
        return a + b;
    }
}
