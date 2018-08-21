package com.zuul.bootc.netty;

import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Map;

public class OnlineUserMap {
    private static Map<String,ChannelHandlerContext> userOnLine=new HashMap<>();

    public static Map<String,ChannelHandlerContext> getUserOnLine(){
        return userOnLine;
    }

}
