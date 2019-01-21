package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class LoginQueueUsingSemaphoreTest {
	
	
	@Test
	public void givenLoginQueue_whenReachLimit_thenBlockedv2() throws InterruptedException {
		System.out.println("given LoginQueue when Reach Limit then Blocked");
		int slots = 10;
		
		ExecutorService executorService = Executors.newFixedThreadPool(slots);
		LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(new Semaphore(slots));
		IntStream
			.range(0, slots)
			.forEach(user -> executorService.execute(() -> {
							try {
								loginQueue.tryLogin();
								System.out.println("available slot: " + loginQueue.availableSlots());
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					)
			);
		//How to wait for all threads to finish, using ExecutorService?
		executorService.shutdown();
		executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

		System.out.println("final available slot: " + loginQueue.availableSlots());

		assertEquals(0, loginQueue.availableSlots());
		assertFalse(loginQueue.tryLogin());
		
		loginQueue.logout();
		assertTrue(loginQueue.availableSlots() > 0);
		assertTrue(loginQueue.tryLogin());

	}
}
