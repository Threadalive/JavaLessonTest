package com.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2019/12/3 22:05
 */
public class SimpleComsumer {
    public static void main(String args[]){
        if(args.length == 0){
            System.out.println("Enter topic name");
            return;
        }
        String topicName = args[0];

        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Arrays.asList(topicName));

        while (true){
            ConsumerRecords<String, String> records = consumer.poll(100);

            for (ConsumerRecord<String, String> record:records){
                System.out.printf("topic = %s,offset = %d, key = %s, value = %s\n",
                        record.topic(), record.offset(), record.key(), record.value());
            }
        }
    }

}
