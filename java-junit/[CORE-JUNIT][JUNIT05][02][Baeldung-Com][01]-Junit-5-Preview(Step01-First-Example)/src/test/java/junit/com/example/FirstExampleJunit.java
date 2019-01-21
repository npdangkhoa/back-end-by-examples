package junit.com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class FirstExampleJunit {
	
	@Test
	void trueAssumption() {
		assumeTrue(5 > 1);
	}
	
	@Test
	 void AssumptionThat() {
		//assumeThat(false, ()-> assertEquals(3, 2));
	}
	
	@Test
	public void FirstJunit05() {
		System.out.println("First Junit 05");
	}
	
	@Test
	void lambdaExpressions() {
		assertTrue(Stream.of(1,2,3).mapToInt(i-> i).sum() > 5);
	}
}
