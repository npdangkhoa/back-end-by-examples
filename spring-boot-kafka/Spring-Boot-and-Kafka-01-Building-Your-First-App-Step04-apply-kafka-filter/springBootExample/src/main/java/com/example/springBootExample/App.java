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
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@SpringBootApplication
public class App {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		
        MessageProducer producer = context.getBean(MessageProducer.class);
	    MessageListener listener = context.getBean(MessageListener.class);

        /*
         * Sending a Hello World message to topic 'baeldung'. 
         * Must be recieved by both listeners with group foo
         * and bar with containerFactory fooKafkaListenerContainerFactory
         * and barKafkaListenerContainerFactory respectively.
         * It will also be recieved by the listener with
         * headersKafkaListenerContainerFactory as container factory
         */
	    producer.sendMessage("Hello, World!");
	    listener.latch.await(10, TimeUnit.SECONDS);
	    
	    
        /*
         * Sending message to a topic with 5 partition,
         * each message to a different partition. But as per
         * listener configuration, only the messages from
         * partition 0 and 3 will be consumed.
         */
	    for (int i = 0; i <= 5; i++) {
			producer.sendMessageToPartion(i + " Hello To Partioned Topic!", i);
		}
	    listener.partitionLatch.await(3, TimeUnit.SECONDS);
	    
        /*
         * Sending message to 'filtered' topic. As per listener
         * configuration,  all messages with char sequence
         * 'World' will be discarded.
         */
	    producer.sendMessageToFiltered("Hello Baeldung!");
	    producer.sendMessageToFiltered("Hello World!");
	    listener.filterLatch.await(10, TimeUnit.SECONDS);

	    
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



	public void sendMessageToFiltered(String string) {
		kafkaTemplate.send(filteredTopicName, string);
	}



	public void sendMessageToPartion(String message, int partition) {
		kafkaTemplate.send(partionedTopicName, partition, null, message);
	}
	
	
}

class MessageListener {

	CountDownLatch filterLatch = new CountDownLatch(3);

	CountDownLatch partitionLatch = new CountDownLatch(3);
	
	CountDownLatch latch = new CountDownLatch(3);
	
	@KafkaListener(topics="${message.topic.name}", groupId="foo", containerFactory="fooKafkaListenerContainerFactory")
	public void listenGroupFoo(String message) {
		System.out.println("Recive message in group 'foo': " + message);
		latch.countDown();
	}
	
	@KafkaListener(topics="${message.topic.name}", groupId="bar", containerFactory="barKafkaListenerContainerFactory")
	public void listenGroupBar(String message) {
		System.out.println("Recive message in group 'bar': " + message);
		latch.countDown();
	}
	
	@KafkaListener(topicPartitions= @TopicPartition(topic= "${partitioned.topic.name}", partitions= {"0", "5"}))
	public void listenToPartition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition ) {
        System.out.println("Received Message: " + message + " from partition: " + partition);
		this.partitionLatch.countDown();
	}
	
	@KafkaListener(topics="${filtered.topic.name}", containerFactory = "partitionsKafkaListenerContainerFactory")
	public void listenWithFilter(String message) {
        System.out.println("Recieved Message in filtered listener: " + message);
		this.filterLatch.countDown();
	}
	
}

