package com.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;

public class app {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
		MyDevTeam t1 = new MyDevTeam(cyclicBarrier, "dev 01", 5);
		MyDevTeam t2 = new MyDevTeam(cyclicBarrier, "dev 02", 10);
		MyQCTeam qc = new MyQCTeam();
		
		if(!cyclicBarrier.isBroken()){
			t1.start();
			t2.start();
		}
		qc.start();

	}
}

class MyDevTeam extends Thread {
	private CyclicBarrier cyclicBarrier;
	private int numberOfTime;

	public MyDevTeam(CyclicBarrier cyclicBarrier, String name, int numberOfTime) {
		super(name);
		this.cyclicBarrier = cyclicBarrier;
		this.numberOfTime = numberOfTime;
	}

	@Override
	public void run() {
        System.out.println("Task assigned to development team " + Thread.currentThread().getName());

        try {
			Thread.sleep(numberOfTime);
			//Here await() method waits for multiple threads to wait for each other using 
	        this.cyclicBarrier.await();
	        System.out.println("Task finished to development team " + Thread.currentThread().getName());

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}


class MyQCTeam extends Thread {

	@Override
	public void run() {
        System.out.println("Task assigned to QA team");
        try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        System.out.println("Task finished by QA team");
	}
}