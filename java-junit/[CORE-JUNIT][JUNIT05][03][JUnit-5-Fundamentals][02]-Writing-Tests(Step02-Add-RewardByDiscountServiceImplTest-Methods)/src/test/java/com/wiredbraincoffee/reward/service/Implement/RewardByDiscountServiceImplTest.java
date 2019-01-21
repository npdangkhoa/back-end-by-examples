package com.wiredbraincoffee.reward.service.Implement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.wiredbraincoffee.product.entity.Product;
import com.wiredbraincoffee.reward.entity.RewardInformation;
import com.wiredbraincoffee.reward.service.RewardByDiscountServiceImpl;

public class RewardByDiscountServiceImplTest {
	
	@Test
	public void setNeededPointsTest() {
		RewardByDiscountServiceImpl discountService = new RewardByDiscountServiceImpl();
		discountService.setNeededPoints(100);
		
		assertEquals(100, discountService.getNeededPoints());
	}
	
	
	@Test
	public void setPercentageTest() {
		RewardByDiscountServiceImpl discountService = new RewardByDiscountServiceImpl();
		discountService.setPercentage(0.1);		
		assertEquals(0.1, discountService.getPercentage());		
	}
	
	/**
	 * Apply Reward With New Customer With Zero Customer Point
	 */
	@Test
	public void ApplyRewardWithNewCustomerWithZeroCustomerPoint() {
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
