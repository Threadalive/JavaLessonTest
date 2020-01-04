package com.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2019/12/5 11:46
 */
public class ConsumerGroup {
    public static void main(String args[]){
        if(args.length < 2){
            System.out.println("Usage: consumer <topic> <groupname>");
            return;
        }

        String topic = args[0].toString();
        String group = args[1].toString();
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", group);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer consumer = new KafkaConsumer(props);

        consumer.subscribe(Arrays.asList(topic));

        System.out.println("Subscribed to topic"+topic);

        while (true){
            ConsumerRecords<String,String> records = consumer.poll(100);
            for (ConsumerRecord record:records){
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
            }
        }

    }

}
