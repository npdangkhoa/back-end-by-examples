package com.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class app {

	private static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(1);
	public static void main(String[] args) {
		
		new Thread(new ConsummerRunnable(blockingQueue)).start();
		new Thread(new ProducerRunnable(blockingQueue)).start();

	}

}
