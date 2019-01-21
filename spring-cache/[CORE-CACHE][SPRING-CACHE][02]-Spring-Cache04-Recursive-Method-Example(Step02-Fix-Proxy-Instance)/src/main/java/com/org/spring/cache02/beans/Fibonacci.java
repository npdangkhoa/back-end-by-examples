package com.org.spring.cache02.beans;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@Cacheable("fibonacci")
public class Fibonacci {
	private int executions = 0;

	public int getExecutions() {
		return executions;
	}

	public void resetExecutions() {
		this.executions = 0;
	}
	
	/**
	 * In the main() method we obtained an instance of the Fibonacci class through Spring.
	 *  In turn, Spring wrapped our object into a proxy.
	 *   Therefore within the main() method, we only have access to the proxy. 
	 *   But the valueAt() method within the Fibonacci class, calls itself (recursion). 
	 *   This is not calling the valueAt() method through the proxy, 
	 *   but directly from Fibonacci class. Therefore the proxy is bypassed. 
	 *   That is why we are not caching the value at the recursion level.
	 * @param index
	 * @return
	 */
	public long valueOf(int index, Fibonacci callback) {
		executions ++;
		if (index < 2) {
			return 1;
		}
		return callback.valueOf(index - 1, callback) + callback.valueOf(index -2, callback);
	}
}
