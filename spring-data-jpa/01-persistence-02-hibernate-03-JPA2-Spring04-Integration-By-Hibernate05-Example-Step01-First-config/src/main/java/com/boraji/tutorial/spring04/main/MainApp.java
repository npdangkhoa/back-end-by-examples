package com.boraji.tutorial.spring04.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.boraji.tutorial.spring00.config.AppConfig;
import com.boraji.tutorial.spring03.Service.PersonService;

public class MainApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean(PersonService.class);
	}
}
