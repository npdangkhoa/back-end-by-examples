package com.boraji.tutorial.spring04.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.boraji.tutorial.spring00.config.PersistenceConfig;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);

	}
}
