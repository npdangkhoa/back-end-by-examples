package com.wiredbraincoffee.reward.service.Implement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class RewardByGiftServiceImplWithDynamicTest {
	
	@TestFactory
	Collection<DynamicTest> giftProductNotInOrderRewardNotApplied() {
		return Arrays.asList(
				dynamicTest("dynamic test 01", ()-> {
					assertEquals(1, 1);
				}),
				dynamicTest("dynamic test 02", ()-> {
					assertEquals(2, 2);
				})
		);
	}
	
	
	
}
