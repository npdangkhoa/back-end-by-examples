package com.org.spring.reactor05.config;

import static reactor.bus.selector.Selectors.$;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.org.spring.reactor03.Consumer.NotificationConsumer;

import reactor.Environment;
import reactor.bus.EventBus;


@ComponentScan({"com.org.spring.reactor04.controller", 
				"com.org.spring.reactor02.service",
				"com.org.spring.reactor03.Consumer"})
@SpringBootApplication
public class Application implements CommandLineRunner {
	private final Logger LOG = org.slf4j.LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private EventBus eventBus;
	
	@Autowired
	private NotificationConsumer notificationConsumer;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	EventBus createEventBus(Environment env) {
		return EventBus.create(env, Environment.THREAD_POOL);
	}
	
	@Bean
	Environment env() {
		return Environment.initializeIfEmpty().assignErrorJournal();
	}

	@Override
	public void run(String... arg0) throws Exception {
		eventBus.on($("notificationConsumer"), notificationConsumer);
	}
}
