package com.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "topic1", groupId = "group_id")
    public void consumeTopic1(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message from topic1 -> %s", message));
    }
    
    @KafkaListener(topics = "topic2", groupId = "group_id")
    public void consumeTopic2(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message from topic2 -> %s", message));
    }
}