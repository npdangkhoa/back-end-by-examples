package org05.com.parameterized.test03.test.with.single.parameter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ParameterizedTest {

	@Parameter
	public String domainName;

	@Parameters
	public static Object[] data() {
		return new Object[] {
                "google.com",
                "mkyong.com",
                "twitter.com"
		};
	}

	@Test
	public void test() {
		assertThat(DomainUtils.isValid(domainName), is(true));
	}
}
