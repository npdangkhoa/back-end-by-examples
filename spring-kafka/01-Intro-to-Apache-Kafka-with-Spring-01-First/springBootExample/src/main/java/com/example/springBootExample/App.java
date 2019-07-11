package com.example.springBootExample;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@SpringBootApplication
public class App {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		
        MessageProducer producer = context.getBean(MessageProducer.class);

//	    MessageListener listener = context.getBean(MessageListener.class);

//	    
	    producer.sendMessage("Hello, World!");
//	    listener.latch.await(10, TimeUnit.SECONDS);
	}
	
	@Bean
	public MessageListener messageListener() {
		return new MessageListener();
	}
	
	@Bean
	public MessageProducer messageProducer() {
		return new MessageProducer();
	}
}



class MessageListener {

	CountDownLatch latch = new CountDownLatch(3);
	
	@KafkaListener(topics="${message.topic.name}", groupId="foo", containerFactory="fooKafkaListenerContainerFactory")
	public void listenGroupFoo(String message) {
		System.out.println("Recive message in group 'foo': " + message);
		latch.countDown();
	}
	
}


class MessageProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
    
    @Value(value = "${message.topic.name}")
    private String messageTopicName;

    @Value(value = "${partitioned.topic.name}")
    private String partionedTopicName;

    @Value(value = "${filtered.topic.name}")
    private String filteredTopicName;

    @Value(value = "${greeting.topic.name}")
    private String greetingTopicName;
    
    

	public void sendMessage(String message) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(messageTopicName, message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onFailure(Throwable ex) {
		         System.out.println("Unable to send message=["
		                 + message + "] due to : " + ex.getMessage());
			}

			@Override
			public void onSuccess(SendResult<String, String> result) {
	            System.out.println("Sent message=[" + message + 
	                    "] with offset=[" + result.getRecordMetadata().offset() + "]");
				
			}
		});
	}
}