package org.com.spring.boot01.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"org.com.spring.boot02.controller", "org.com.spring.boot01.config"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

