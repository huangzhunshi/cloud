package com.zuul.bootc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTestApp {

    private static Logger logger= LoggerFactory.getLogger("LogTestApp");
    public static void main(String args[]){
        logger.info("xxxx");
        System.out.println("xxxxx");
    }
}
