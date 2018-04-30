package com.zuul.bootc.kafka;

/**
 * 自定义异常
 */
public class YihuiException extends Exception {

    public YihuiException(){
        super();
    }

    public YihuiException(String msg){
        super(msg);
    }
}
