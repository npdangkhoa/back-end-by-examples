package org.com.spring.boot05.exception;

public class BookNotFoundException extends RuntimeException {
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	public BookNotFoundException() {
		super();
	}
}
