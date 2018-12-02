package com.zuul.bootc.zk;



import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

import java.io.IOException;
import java.util.List;

public class AppMain {
    public static void main(String[] args) throws IOException {

        watchnode();
    }

    /**
     * 监听zk节点变化
     * @throws IOException
     */
    public static void watchnode() throws IOException {
        ZkClient zkClient=new ZkClient("127.0.0.1:2181",5000);
//        zkClient.subscribeChildChanges("/yihui", new IZkChildListener() {
//            @Override
//            public void handleChildChange(String s, List<String> list) throws Exception {
//                System.out.println("buibui"+s);
//            }
//        });

        zkClient.subscribeDataChanges("/yihui", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println(s);
                System.out.println(o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        });
        System.in.read();

    }


    public static void addNode(){
        ZkClient zkClient=new ZkClient("127.0.0.1:2181",5000);


        zkClient.createPersistent("/yihui",true);

        List<String> list= zkClient.getChildren("/");
        zkClient.close();
    }



    public static void zkaddnode() throws IOException {
        ZkClient zkClient=new ZkClient("127.0.0.1:2181",200);
        zkClient.create("/yihui","haha", CreateMode.EPHEMERAL);

        zkClient.close();
        System.out.println("创建成功");
    }
}
