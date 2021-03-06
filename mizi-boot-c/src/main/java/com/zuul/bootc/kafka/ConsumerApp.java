package com.zuul.bootc.kafka;




import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.*;



/**
 * kafka消费者 demo来源：https://blog.csdn.net/wei389083222/article/details/78252741
 */
public class ConsumerApp {

    private static final String topic="huangzhun";
    public static void main(String[] s){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.146.128:9092");
        props.put("group.id", "1");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);

        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            System.out.println("poll start...");
            ConsumerRecords<String, String> records = consumer.poll(1000);
            int count = records.count();
           // System.out.println("the numbers of topic:" + count);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
                System.out.println("");
        }
    }


}
