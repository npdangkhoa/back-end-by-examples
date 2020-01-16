package io.javabrain.movieserviceeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MovieServiceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceEurekaServerApplication.class, args);
	}

}
