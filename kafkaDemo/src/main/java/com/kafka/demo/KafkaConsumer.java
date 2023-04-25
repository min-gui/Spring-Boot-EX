package com.kafka.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "sample-topic")
    public void consume(String message) {
        System.out.println(String.format("Consumed message : %s", message));
    }
}
