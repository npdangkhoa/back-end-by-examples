package com.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class app {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
		
		Future<?> future = service.schedule(task, 5, TimeUnit.SECONDS);
		
		// run as Asynchronous 
		if (future.isDone() && !future.isCancelled()) {
			future.get();
		}
		System.out.println("complete !");
	}
}
