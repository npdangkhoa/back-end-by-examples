package com.org.spring.cache03.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.org.spring.cache01.config.SpringConfig;
import com.org.spring.cache02.beans.Fibonacci;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		final long start = System.nanoTime();

		Fibonacci fibonacci = context.getBean(Fibonacci.class);
		final long fibNumber = fibonacci.valueOf(50);
		final int executions = fibonacci.getExecutions();
		final long timeTaken = System.nanoTime() - start;
		System.out.printf("The 5th Fibonacci number is: %d (%,d executions in %,d NS)%n", fibNumber, executions,
				timeTaken);
	}

}
