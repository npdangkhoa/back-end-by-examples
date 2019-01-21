package com.example;

import java.util.concurrent.BlockingQueue;

public class ProducerRunnable implements Runnable{

	private BlockingQueue<String> queue;
	private int productId;

	
	public ProducerRunnable(BlockingQueue<String> queue, int id) {
		super();
		this.queue = queue;
		this.productId = id;
	}


	@Override
	public void run() {
		String product = "product: " + this.productId;
		try {
			queue.put(product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("produce product: " + product);
	}

}

