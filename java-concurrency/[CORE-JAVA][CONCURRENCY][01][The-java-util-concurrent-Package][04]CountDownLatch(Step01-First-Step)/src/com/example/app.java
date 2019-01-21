package com.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

public class app {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		MyDevTeam t1 = new MyDevTeam(countDownLatch, "dev 01");
		MyDevTeam t2 = new MyDevTeam(countDownLatch, "dev 02");
		MyQCTeam qc = new MyQCTeam();
		
		t1.start();
		t2.start();
		
		//Here await() method waits for countdownlatch flag to become 0, and countDown() method decrements countdownlatch flag by 1.
		countDownLatch.await();

		qc.start();

	}
}

class MyDevTeam extends Thread {
	private CountDownLatch countDownLatch;

	public MyDevTeam(CountDownLatch countDownLatch, String name) {
		super(name);
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
        System.out.println("Task assigned to development team " + Thread.currentThread().getName());

        try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("Task finished to development team " + Thread.currentThread().getName());
        this.countDownLatch.countDown();
	}
}


class MyQCTeam extends Thread {

	@Override
	public void run() {
        System.out.println("Task assigned to QA team");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        System.out.println("Task finished by QA team");
	}
}