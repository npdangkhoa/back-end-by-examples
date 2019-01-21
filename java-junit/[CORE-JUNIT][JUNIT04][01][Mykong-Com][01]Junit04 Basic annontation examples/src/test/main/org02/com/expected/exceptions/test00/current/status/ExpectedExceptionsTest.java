package org02.com.expected.exceptions.test00.current.status;

import java.util.ArrayList;

import org.junit.Test;

public class ExpectedExceptionsTest {
	
	@Test
	public void testDivisionWithException() {
		int i = 1 / 0;
	}
	
	@Test
	public void testEmptyList() {
		new ArrayList().get(0);
	}
}
