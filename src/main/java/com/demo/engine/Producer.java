package com.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    // Default topics
    public static final String TOPIC1 = "topic1";
    public static final String TOPIC2 = "topic2";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        sendMessage(TOPIC1, message);
    }
    
    public void sendMessage(String topic, String message) {
        logger.info(String.format("#### -> Producing message -> %s to %s", message, topic));
        this.kafkaTemplate.send(topic, message);
    }
}