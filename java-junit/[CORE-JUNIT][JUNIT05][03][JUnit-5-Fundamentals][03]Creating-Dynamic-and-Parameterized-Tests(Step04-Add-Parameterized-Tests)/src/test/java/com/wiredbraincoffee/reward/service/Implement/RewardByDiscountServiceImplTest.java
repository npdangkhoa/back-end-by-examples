package com.wiredbraincoffee.reward.service.Implement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.wiredbraincoffee.product.entity.Product;
import com.wiredbraincoffee.reward.entity.RewardInformation;
import com.wiredbraincoffee.reward.service.RewardByDiscountServiceImpl;

@DisplayName("Reward by Conversion \uD83D\uDE04")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class RewardByDiscountServiceImplTest {

	private RewardByDiscountServiceImpl discountService = null;

	public RewardByDiscountServiceImplTest() {
	}

	@DisplayName("Then 100 points should be need for 10% discount")
	@BeforeEach
	public void beforeEach() {
		discountService = new RewardByDiscountServiceImpl();

		discountService.setNeededPoints(100);
		discountService.setPercentage(0.1);
	}

	@Test
	public void setNeededPointsTest() {
		assertEquals(100, discountService.getNeededPoints());
	}

	@Test
	public void setPercentageTest() {
		assertEquals(0.1, discountService.getPercentage());
	}
	
	/**
	 * Apply Reward With New Customer With two hundred Customer Point
	 */
	@DisplayName("Given there's a small order")
	@Nested
	class BigOrder {
		private List<Product> largeOrders = null;
		private RewardInformation reward = null;

		@DisplayName("Given the customer has 200 points")
		@BeforeEach
		public void setup() {
			largeOrders = new ArrayList<Product>();
			largeOrders.add(new Product(1, "small Decaf", 1.99));
			largeOrders.add(new Product(2, "Big Decaf", 2.49));
			largeOrders.add(new Product(3, "Big Latte", 1.99));
			largeOrders.add(new Product(4, "Big Tea", 2.99));
			largeOrders.add(new Product(5, "Espresso", 2.99));
			
			reward = discountService.applyReward(largeOrders, 200);

		}
		
		@DisplayName("Then discount should by 100")
		@Test
		public void checkDiscount() {
			assertEquals(100, reward.getPointsRedeemed());
		}

		@DisplayName("Then points redeemed should by 1.245")
		@Test
		public void checkPointRedeemed() {
			assertEquals(1.245, reward.getDiscount());
		}
	}

	/**
	 * Apply Reward With New Customer With Zero Customer Point
	 */
	@DisplayName("Given there's a big order")
	@Nested
	class SmallOrder {
		private RewardInformation reward = null;
		private List<Product> smallOrder = null;

		@DisplayName("Given the customer has zero points")
		@BeforeEach
		public void setup() {
			smallOrder = new ArrayList<Product>();
			smallOrder.add(new Product(1, "small Decaf", 1.99));
			
			reward = discountService.applyReward(smallOrder, 0);	
		}

		@DisplayName("Then discount should by zero")
		@Test
		public void checkDiscount() {
			assertEquals(0, reward.getDiscount());
		}

		@DisplayName("Then points redeemed should by zero")
		@Test
		public void checkPointRedeemed() {
			assertEquals(0, reward.getPointsRedeemed());
		}

	}
}
