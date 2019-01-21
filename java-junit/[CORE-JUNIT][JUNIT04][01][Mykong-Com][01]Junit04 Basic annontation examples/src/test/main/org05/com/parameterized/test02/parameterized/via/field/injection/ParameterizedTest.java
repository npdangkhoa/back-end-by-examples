package org05.com.parameterized.test02.parameterized.via.field.injection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org05.com.parameterized.test01.parameterized.via.constructor.MathUtils;

@RunWith(value = Parameterized.class)
public class ParameterizedTest {

	// default value = 0
	@Parameter(value = 0)
	public int numberA;

	@Parameter(value = 1)
	public int numberB;

	@Parameter(value = 2)
	public int expected;

	/**
	 * Note
	 * For @Parameters, the “name” attribute is optional, it helps you to identify individual test cases by providing a unique name.
	 * What is {0}, {1} and {2}?
	 * If the parameter is “{ 3, 4, 7 }”, then {0} = 3, {1} = 4, {2} = 7.
	 * @return
	 */
	@Parameters(name = "{index}: testAdd({0}+{1}) = {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, 1, 2 }, { 2, 2, 4 }, { 8, 2, 10 }, { 4, 5, 9 }, { 5, 5, 10 } });
	}

	@Test
	public void test_addTwoNumbes() {
		assertThat(MathUtils.add(numberA, numberB), is(expected));
	}

}
