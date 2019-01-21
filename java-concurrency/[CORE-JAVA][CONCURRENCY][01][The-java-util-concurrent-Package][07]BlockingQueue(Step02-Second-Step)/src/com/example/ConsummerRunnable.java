package com.example;

import java.util.concurrent.BlockingQueue;

public class ConsummerRunnable implements Runnable{
	private BlockingQueue<String> queue;
		
	public ConsummerRunnable(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			String product = queue.take();
			System.out.println("consumer product: " + product);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
