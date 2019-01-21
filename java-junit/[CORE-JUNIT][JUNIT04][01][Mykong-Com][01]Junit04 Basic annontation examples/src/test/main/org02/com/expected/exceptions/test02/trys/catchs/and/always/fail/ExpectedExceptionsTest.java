package org02.com.expected.exceptions.test02.trys.catchs.and.always.fail;

import java.util.ArrayList;

import org.junit.Test;

public class ExpectedExceptionsTest {
	
	@Test(expected = ArithmeticException.class)
	public void testDivisionWithException() {
		int i = 1 / 0;
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testEmptyList() {
		new ArrayList().get(0);
	}
}
