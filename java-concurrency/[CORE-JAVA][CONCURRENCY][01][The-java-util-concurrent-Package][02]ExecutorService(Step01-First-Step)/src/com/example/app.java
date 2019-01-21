package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class app {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.submit(new Task("thread 01"));
	}
}

class Task implements Runnable{
	String seq;
	
	public Task(String string) {
		seq = string;
	}

	@Override
	public void run() {
		System.out.println(seq);
	}
	
}



