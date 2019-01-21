package junit.com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wiredbraincoffee.product.entity.Product;
import com.wiredbraincoffee.reward.entity.RewardInformation;
import com.wiredbraincoffee.reward.service.RewardByDiscountServiceImpl;

public class FirstExampleJunit {
	
	
	//Reference: https://github.com/npdangkhoa/back-end-by-examples/tree/master/java-junit
	// knguyen97
	@Test
	public void FirstJunit05() {
		System.out.println("First Junit 05");
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
	
}
