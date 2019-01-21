package com.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class app {

	private static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(1);
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new ConsummerRunnable(blockingQueue)).start();
			
		}
		for (int i = 0; i < 5; i++) {
			new Thread(new ProducerRunnable(blockingQueue, i)).start();

		}

	}
}
