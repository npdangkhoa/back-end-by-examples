package com.example;

import java.util.concurrent.Executor;

public class app {
	public static void main(String[] args) {
		Invoice invoice = new Invoice();
		invoice.execute(() -> {
			System.out.println("First step execute");
		});
	}
}


class Invoice implements Executor{
	@Override
	public void execute(Runnable command) {
		command.run();
	}
	
}