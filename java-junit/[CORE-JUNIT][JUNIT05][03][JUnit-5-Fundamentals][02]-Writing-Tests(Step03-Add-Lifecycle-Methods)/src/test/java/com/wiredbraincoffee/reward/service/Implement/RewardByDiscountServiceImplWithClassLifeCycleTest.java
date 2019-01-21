package com.wiredbraincoffee.reward.service.Implement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.wiredbraincoffee.product.entity.Product;
import com.wiredbraincoffee.reward.entity.RewardInformation;
import com.wiredbraincoffee.reward.service.RewardByDiscountServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RewardByDiscountServiceImplWithClassLifeCycleTest {
	
	
	public RewardByDiscountServiceImplWithClassLifeCycleTest() {
		System.out.println("constructor method");
	}
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("<<<<<<<<<<BEFORE ALL>>>>>>>>>>");
	}
	
	@AfterAll
	public static void AfterAll() {
		System.out.println("<<<<<<<<<<AFTER ALL>>>>>>>>>>");
	}
	
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("<<<<<<<<<<BEFORE EACH>>>>>>>>>>");
	}
	
	@AfterEach
	public void AfterEach() {
		System.out.println("<<<<<<<<<<AFTER EACH>>>>>>>>>>");
	}
		
	
	@Test
	public void setNeededPointsTest() {
		System.out.println("Set Needed Points Test");

		RewardByDiscountServiceImpl discountService = new RewardByDiscountServiceImpl();
		discountService.setNeededPoints(100);
		
		assertEquals(100, discountService.getNeededPoints());
	}
	
	
	@Test
	public void setPercentageTest() {
		System.out.println("Set Percentage Test");

		RewardByDiscountServiceImpl discountService = new RewardByDiscountServiceImpl();
		discountService.setPercentage(0.1);		
		assertEquals(0.1, discountService.getPercentage());		
	}
	
	/**
	 * Apply Reward With New Customer With Zero Customer Point
	 */
	@Test
	public void ApplyRewardWithNewCustomerWithZeroCustomerPoint() {
		System.out.println("Apply Reward With New Customer With Zero Customer Point");

		RewardByDiscountServiceImpl discountServiceImpl = new RewardByDiscountServiceImpl();
		discountServiceImpl.setNeededPoints(100);
		discountServiceImpl.setPercentage(0.1);
		
		List<Product> items = new ArrayList<Product>();
		items.add(new Product(1, "small Decaf", 1.99));
		RewardInformation rewardInformation = discountServiceImpl.applyReward(items, 0);
		
		long pointsRedeemed = rewardInformation.getPointsRedeemed();
		double discount = rewardInformation.getDiscount();
		
		assertEquals(0, pointsRedeemed);
		assertEquals(0, discount);
		
	}
	
	
	/**
	 * Apply Reward With New Customer With two hundred Customer Point
	 */
	@Test
	public void ApplyRewardWithOldCustomerWithTwoHundredCustomerPoint() {
		System.out.println("Apply Reward With New Customer With Two Hundred Customer Point");

		RewardByDiscountServiceImpl discountServiceImpl = new RewardByDiscountServiceImpl();
		discountServiceImpl.setNeededPoints(100);
		discountServiceImpl.setPercentage(0.1);
		
		List<Product> items = new ArrayList<Product>();
		items.add(new Product(1, "small Decaf", 10));
		RewardInformation rewardInformation = discountServiceImpl.applyReward(items, 200);
		
		long pointsRedeemed = rewardInformation.getPointsRedeemed();
		double discount = rewardInformation.getDiscount();
		
		assertEquals(100, pointsRedeemed);
		assertEquals(1, discount);
		
	}
}
