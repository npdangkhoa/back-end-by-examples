package com.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    
    private static Logger logger = LoggerFactory.getLogger(Producer.class);
    
    private String TOPIC = "users";


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    
    public void sendMessage(String message) {
        logger.info(String.format("############# -> Producing message -> ", message));
       kafkaTemplate.send(TOPIC, message);
    }
}
