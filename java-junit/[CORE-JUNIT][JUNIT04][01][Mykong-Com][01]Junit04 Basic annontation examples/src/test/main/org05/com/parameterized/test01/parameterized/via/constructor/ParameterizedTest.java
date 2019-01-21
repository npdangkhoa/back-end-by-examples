package org05.com.parameterized.test01.parameterized.via.constructor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ParameterizedTest {
	private int numberA;
	private int numberB;
	private int expected;
	
	// name attribute is optional.
    //@Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
            {1, 1, 2},
            {2, 2, 4},
            {8, 2, 10},
            {4, 5, 9},
            {5, 5, 10}
		}); 
	}
	
	@Test
	public void TestAddTwoNumbers() {
		assertThat(MathUtils.add(numberA, numberB), is(expected));
	}
	

	// inject via constructor
	public ParameterizedTest(int numberA, int numberB, int expected) {
		super();
		this.numberA = numberA;
		this.numberB = numberB;
		this.expected = expected;
	}


	

}
