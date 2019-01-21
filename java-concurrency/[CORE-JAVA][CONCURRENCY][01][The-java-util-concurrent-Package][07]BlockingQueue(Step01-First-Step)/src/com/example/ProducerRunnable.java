package com.example;

import java.util.concurrent.BlockingQueue;

public class ProducerRunnable implements Runnable{

	private BlockingQueue<String> queue;

	
	public ProducerRunnable(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}


	@Override
	public void run() {
		String product = "product 01";
		queue.add(product);
		System.out.println("produce product: " + product);
	}

}

