package com.example;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class app {
	public static void main(String[] args) {
		RunnableThread thread01 = new RunnableThread("Thread 01");
		RunnableThread thread02 = new RunnableThread("Thread 02");
		
		Invoice invoice = new Invoice();
		invoice.execute(thread01);
		invoice.execute(thread02);

	}
}


class Invoice implements Executor{
	
	// Step01: init Queue
	final Queue<Runnable> queue = new ArrayDeque<>();
	
	Runnable task;
	
	@Override
	public void execute(Runnable r) {
		
		// Step02: add task in to queue
		queue.offer( new Runnable() {			
			@Override
			public void run() {
				try {
					r.run();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					 next();
				}
			}		
		});		
		
		// Step03: get task in the queue. and execute.
		if (task == null) {
			next();
		}
	}
	
	private synchronized void next() {
		task = queue.poll();
		
		if (task != null) {
			new Thread(task).start();
		}
	}
	
}

class RunnableThread implements Runnable {
	
	private String seq;
	
	
	
	public RunnableThread(String seq) {
		super();
		this.seq = seq;
	}


	public RunnableThread() {
		super();
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("(" + i + ") " + seq);
		}
	}
	
}