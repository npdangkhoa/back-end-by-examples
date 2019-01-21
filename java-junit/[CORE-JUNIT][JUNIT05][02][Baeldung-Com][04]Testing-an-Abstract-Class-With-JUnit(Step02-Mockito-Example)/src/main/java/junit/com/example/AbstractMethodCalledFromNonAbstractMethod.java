package junit.com.example;


public abstract class AbstractMethodCalledFromNonAbstractMethod {
	public abstract String abstractFunc();

	public String defaultImpl() {
		String res = abstractFunc();
		return (res == null) ? "Default" : (res + " Default");
	}
}
