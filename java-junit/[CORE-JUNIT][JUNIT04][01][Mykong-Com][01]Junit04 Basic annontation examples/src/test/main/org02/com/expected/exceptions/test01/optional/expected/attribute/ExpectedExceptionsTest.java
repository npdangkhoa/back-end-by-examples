package org02.com.expected.exceptions.test01.optional.expected.attribute;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class ExpectedExceptionsTest {
	
	@Test
	public void testDivisionWithException() {
		try {
			int i = 1 / 0;
            fail(); //remember this line, else 'may' false positive
		} catch (Exception e) {
			assertThat(e.getMessage(), is("/ by zero"));
		}
		
	}
	
	@Test
	public void testEmptyList() {
		try {
			new ArrayList().get(0);
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Index: 0, Size: 0"));
		}
		
	}
}
