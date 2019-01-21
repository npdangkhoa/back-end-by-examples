package org.com.spring.boot01.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("org.com.spring.boot04.persistence")
@EntityScan("org.com.spring.boot03.entity")
@ComponentScan(basePackages= {"org.com.spring.boot02.controller", 
							  "org.com.spring.boot05b.exception.handler",
						      "org.com.spring.boot01.config"})
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

