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

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class RewardByDiscountServiceImplWithHierarchiesTest {
	
	private RewardByDiscountServiceImpl discountService = null;
	private List<Product> products = null;

	public RewardByDiscountServiceImplWithHierarchiesTest() {
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
		discountService = new RewardByDiscountServiceImpl();

		discountService.setNeededPoints(100);
		discountService.setPercentage(0.1);
		
		products = new ArrayList<Product>();
		products.add(new Product(1, "small Decaf", 1.99));
		products.add(new Product(2, "Big Decaf", 2.49));
		products.add(new Product(3, "Big Latte", 1.99));
		products.add(new Product(4, "Big Tea", 2.99));
		products.add(new Product(5, "Espresso", 2.99));

	}

	@AfterEach
	public void AfterEach() {
		System.out.println("<<<<<<<<<<AFTER EACH>>>>>>>>>>");
	}

	@Test
	public void setNeededPointsTest() {
		System.out.println("Set Needed Points Test");
		assertEquals(100, discountService.getNeededPoints());
	}

	@Test
	public void setPercentageTest() {
		System.out.println("Set Percentage Test");
		assertEquals(0.1, discountService.getPercentage());
	}

	/**
	 * Apply Reward With New Customer With Zero Customer Point
	 */
	@Test
	public void zeroCustomerPoints() {
		System.out.println("Apply Reward With New Customer With Zero Customer Point");

		RewardInformation rewardInformation = discountService.applyReward(products, 0);

		assertEquals(0, rewardInformation.getPointsRedeemed());
		assertEquals(0, rewardInformation.getDiscount());

	}

	/**
	 * Apply Reward With New Customer With two hundred Customer Point
	 */
	@Test
	public void enoughCustomerPointsForDiscount() {
		System.out.println("Apply Reward With New Customer With Two Hundred Customer Point");


		RewardInformation rewardInformation = discountService.applyReward(products, 200);

		assertEquals(100, rewardInformation.getPointsRedeemed());
		assertEquals(1.245, rewardInformation.getDiscount(), 0.1);

	}
}
