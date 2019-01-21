package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class app {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.submit(new RunnableThread("thread 01"));
		executor.submit(new RunnableThread("thread 02"));
		executor.submit(new RunnableThread("thread 03"));
		executor.shutdown();

	}
}

class RunnableThread implements Runnable {
	String seq = null;
	public RunnableThread(String seq){
		this.seq = seq;
	}
    @Override
    public void run() {
        for (int cnt = 0; cnt < 5; cnt++) {
            System.out.println(seq+":" + cnt);
        }
    }
}
