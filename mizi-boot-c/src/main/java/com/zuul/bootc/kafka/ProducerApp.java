package com.zuul.bootc.kafka;

import io.netty.handler.codec.string.StringEncoder;
import org.apache.kafka.clients.producer.*;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * kakfa 生产者
 */
public class ProducerApp {

    private final static String topic = "huangzhun";

    private void execMsgSend() throws  Exception{
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.146.128:9092");
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> procuder = new KafkaProducer<String, String>(props);
       // String topic = "test";
            String value = " this is another message_";
            ProducerRecord<String,String> record = new ProducerRecord<String, String>(topic,value);
        //procuder.send(record);

            procuder.send(record,new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    System.out.println("message send to partition " + metadata.partition() + ", offset: " + metadata.offset());
                }
            });
            System.out.println(" ----   success");

        System.out.println("send message over.");
        procuder.close();
    }
    public static void main(String[] args) throws  Exception{
        ProducerApp test1 = new ProducerApp();
        test1.execMsgSend();
    }


//    public static void main(String[] arg) {
//        sendMsg("java-p");
//        System.out.println("发送成功!!!!");
//
//
//    }




    /**
     * 发送消息
     * @param msg 消息内容
     */
    private static void sendMsg(String msg){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.146.128:9092");
//        props.put("zookeeper.connect",
//                "192.168.146.128:2181");// 声明zk
//        props.put("serializer.class", StringEncoder.class.getName());
//        props.put("metadata.broker.list",
//                "192.168.146.128:9092");
//
//        props.put("acks", "all");
//        props.put("retries", 0);
//        props.put("batch.size", 16384);
//        props.put("linger.ms", 1);
//        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        //生产者发送消息

        Producer<String, String> procuder = new KafkaProducer<String,String>(props);
        ProducerRecord<String, String> pmsg = new ProducerRecord<String, String>(topic, msg);
        procuder.send(pmsg);
    }
}
