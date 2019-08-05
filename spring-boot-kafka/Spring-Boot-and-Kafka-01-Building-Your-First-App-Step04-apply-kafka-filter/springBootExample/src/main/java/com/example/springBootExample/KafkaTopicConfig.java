package com.example.springBootExample;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootStrapAddress;
	
	@Value(value="${message.topic.name}")
	private String messageTopic;
	
	@Value(value="${greeting.topic.name}")
	private String greeting;
	
	@Value(value="${filtered.topic.name}")
	private String filtered;
	
	@Value(value="${partitioned.topic.name}")
	private String partitioned;
	
	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> config = new HashMap<>();
		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapAddress);
		return new KafkaAdmin(config);
	}

	@Bean
	public NewTopic messageTopic() {
		return new NewTopic(messageTopic, 1, (short) 1);
	}
	
	@Bean
	public NewTopic greetingTopic() {
		return new NewTopic(partitioned , 6, (short) 1);
	}
	
//	@Bean
//	public NewTopic partionedTopic() {
//		return new NewTopic(greeting, 1, (short) 1);
//	}
//	
//	@Bean
//	public NewTopic filteredTopic() {
//		return new NewTopic(filtered, 1, (short) 1);
//	}
}
