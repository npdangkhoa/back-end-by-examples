package junit.com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AbstractIndependentTestWith02MockitoSolution {
	AbstractIndependent abstractIndependent = null;
	
	
	@Test
	public void givenNonAbstractMethod_whenMockitoMock_testCorrectBehaviour() {
		abstractIndependent = Mockito.mock(AbstractIndependent.class, Mockito.CALLS_REAL_METHODS);
		assertEquals("DEFAULT-1", abstractIndependent.defaultImpl());
				
	}
}
