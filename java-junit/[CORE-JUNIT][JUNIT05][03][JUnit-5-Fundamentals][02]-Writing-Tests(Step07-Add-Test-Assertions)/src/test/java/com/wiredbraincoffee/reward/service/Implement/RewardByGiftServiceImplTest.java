package com.wiredbraincoffee.reward.service.Implement;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.wiredbraincoffee.product.entity.Product;
import com.wiredbraincoffee.reward.entity.RewardInformation;
import com.wiredbraincoffee.reward.service.RewardByGiftServiceImpl;

public class RewardByGiftServiceImplTest {
	private RewardByGiftServiceImpl rewardService = null;
	
	@BeforeEach
	public void Setup() {
		rewardService = new RewardByGiftServiceImpl();
		rewardService.setGiftProductId(4);
		rewardService.setNeededPoints(100);
	}
	
	
	private List<Product> buildSampleOrder(int numberOfProducts) {
		List<Product> items = IntStream.range(1, numberOfProducts)
				.mapToObj(i -> new Product(i, "product " + i, 	2.99))
				.collect(Collectors.toList());
		
		return items;
	}
	
	
	@Test
	@DisplayName("Exception will throw when invalid product ID")
	void exceptionThrowWhenInvalidProductId() {
		long productid = 0;
		Exception exception = assertThrows(Exception.class,() -> rewardService.setGiftProductId(productid));
		assertTrue(exception.getMessage().contains(String.valueOf(productid)));
	}
	
	
	@Test
	@DisplayName("should not exceed timeout")
	@Disabled("Optimization not implement")
	void timeoutNotExceed() {
		int numberProduct = 50_000;
		
		assertTimeout(Duration.ofMillis(4), 
				() -> 
						rewardService.applyReward(buildSampleOrder(numberProduct)
													, 200
													)
		);
		
	}
	
	
	@Test
	@DisplayName("conrrect product ID is set")
	void correctProductID() {
		assertEquals(4, rewardService.getGiftProductId(),
				()-> {
					System.out.println("Lazy loaded!");
					return "Error! the product Id is incorrect";
				});
	}
	
	
	@Test
	@DisplayName("Reward applied with enought points")
	void rewardApplied() {
		RewardInformation rewardInformation = rewardService.applyReward(buildSampleOrder(10), 200);
		
		
		assertAll("Reward info errors",
				()-> assertNotNull(rewardInformation),
				()-> assertEquals(2, rewardInformation.getDiscount()),
				()-> assertEquals(10, rewardInformation.getPointsRedeemed())
		);
	}
	
	
	
	
	
}
