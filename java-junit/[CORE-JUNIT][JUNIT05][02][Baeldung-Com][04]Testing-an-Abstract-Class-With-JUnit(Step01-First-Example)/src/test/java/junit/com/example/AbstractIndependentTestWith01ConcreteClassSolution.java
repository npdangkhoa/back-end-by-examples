package junit.com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbstractIndependentTestWith01ConcreteClassSolution {
	AbstractIndependent abstractIndependent = null;
	
	@BeforeEach
	public void setup() {
		abstractIndependent = new AbstractIndependent() {
			
			@Override
			public int abstractFunc() {
				return 0;
			}
		};
	}
	
	@Test
	public void givenNonAbstractMethod_whenConcreteImpl_testCorrectBehaviour() {
		String result = abstractIndependent.defaultImpl();
		assertEquals("default Imple", result);
	}
}
