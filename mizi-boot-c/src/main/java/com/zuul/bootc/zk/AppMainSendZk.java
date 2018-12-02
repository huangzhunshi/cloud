package com.zuul.bootc.zk;

import org.I0Itec.zkclient.ZkClient;

public class AppMainSendZk {

    public static void main(String[] args){
        ZkClient zkClient=new ZkClient("127.0.0.1:2181",5000);
        zkClient.writeData("/yihui","huangzhun007");
        //zkClient.createPersistent("/yihui/aa",true);
        zkClient.close();
    }
}
