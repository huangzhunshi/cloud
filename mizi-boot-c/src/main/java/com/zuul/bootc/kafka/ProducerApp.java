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
            String value = "java-sdk";
            ProducerRecord<String,String> record = new ProducerRecord<String, String>(topic,value);
        //procuder.send(record);

            procuder.send(record,new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    System.out.println("java-sdk " + metadata.partition() + ", offset: " + metadata.offset());
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

}
