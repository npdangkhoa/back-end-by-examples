package junit.com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AbstractPrivateMethodsTest {
	AbstractPrivateMethods abstractIndependent = null;

	@Test
	public void whenMockPrivateMethod_thenVerifyBehaviour() {
		abstractIndependent = Mockito.mock(AbstractPrivateMethods.class, Mockito.CALLS_REAL_METHODS);
		String actual = abstractIndependent.defaultImpl();
		String expect = (LocalDateTime.now().toString() + "DEFAULT-1");
		assertEquals(expect, actual);

	}

}
