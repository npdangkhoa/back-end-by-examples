package com.org.spring.cache04.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.org.spring.cache01.config.SpringConfig;
import com.org.spring.cache02.beans.Worker;
import com.org.spring.cache03.service.WorkerService;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		WorkerService service = context.getBean(WorkerService.class);

		// Load member with id 1
		Worker work = service.getWorkWithId(1);
		System.out.println(work);

		// Load member with id 1 again
		work = service.getWorkWithId(1);
		System.out.println(work);

		
		// Edit member with id 1
		work = new Worker(1, "Joe Vella");
		service.saveWorker(work);

		// Load member with id 1 after it was modified
		work = service.getWorkWithId(1);
		System.out.println(work);

	}

}
