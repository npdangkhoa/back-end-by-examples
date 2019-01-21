package com.example;

import java.util.concurrent.Semaphore;

public class LoginQueueUsingSemaphore {
	private Semaphore semaphore;
	
	
	public LoginQueueUsingSemaphore(Semaphore semaphore) {
		super();
		this.semaphore = semaphore;
	}

	public boolean tryLogin() throws InterruptedException {
		return semaphore.tryAcquire();
	}
	
	public void logout() {
		semaphore.release();
	}
	
	public int availableSlots() {
		return semaphore.availablePermits();
	}
}
