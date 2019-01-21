package com.example;

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
	
	@Override
	public void execute(Runnable r) {
		r.run();
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