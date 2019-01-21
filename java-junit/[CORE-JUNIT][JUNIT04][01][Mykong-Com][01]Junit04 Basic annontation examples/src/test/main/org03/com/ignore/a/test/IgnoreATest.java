package org03.com.ignore.a.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoreATest {

	
	
	@Test
	public void testMath01() {
		assertThat(1+1, is(2));
	}
	
	@Ignore("the failed test may caused by other teams")
	@Test
	public void testMath02() {
		assertThat(1+2, is(5));
	}
}
