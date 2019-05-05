package com.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private Logger logger = LoggerFactory.getLogger(Consumer.class);
    
    @KafkaListener(topics = "users", groupId = "group_id")
    public void receiveMessage(String message) {
        logger.info(String.format("############# -> Receice Message -> %s", message));
    }
}
