package com.org.spring.cache03.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.org.spring.cache01.config.SpringConfig;
import com.org.spring.cache02.beans.Worker;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	
		Worker work = context.getBean(Worker.class);
		
		System.out.println(work.getClass().getName());
		work.longTask(1);
		work.longTask(1);
		work.longTask(1);
		work.longTask(2);
		work.longTask(2);
	}

}
