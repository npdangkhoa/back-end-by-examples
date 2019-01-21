package org02.com.expected.exceptions.test03.rule.expected.exception;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpectedExceptionsTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	@Test
	public void testDivisionWithException() {
		expectedException.expect(ArithmeticException.class);		
		int i = 1 / 0;
	}
	
	@Test
	public void testEmptyList() {
		expectedException.expect(IndexOutOfBoundsException.class);
		new ArrayList().get(0);
	}
}
