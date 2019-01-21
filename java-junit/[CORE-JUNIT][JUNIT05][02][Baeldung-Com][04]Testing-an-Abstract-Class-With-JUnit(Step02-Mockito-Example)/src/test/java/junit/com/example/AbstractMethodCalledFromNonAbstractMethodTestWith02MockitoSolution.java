package junit.com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AbstractMethodCalledFromNonAbstractMethodTestWith02MockitoSolution {
	AbstractMethodCalledFromNonAbstractMethod abstractIndependent = null;
	
	
	@Test
	public void givenDefaultImpl_whenMockAbstractFunc_thenExpectedBehaviour() {
		abstractIndependent = Mockito.mock(AbstractMethodCalledFromNonAbstractMethod.class);
		
		Mockito.when(abstractIndependent.abstractFunc())
		.thenReturn("Abstract Method");
		
		Mockito.doCallRealMethod()
		.when(abstractIndependent)
		.defaultImpl();
		
		assertEquals("Abstract Method Default", abstractIndependent.defaultImpl());
		
	}
}
