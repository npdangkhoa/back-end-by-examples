package org.com.spring.boot05.exception;

public class BookIdMismatchException extends RuntimeException {

	public BookIdMismatchException() {
		super();
	}

	public BookIdMismatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookIdMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookIdMismatchException(String message) {
		super(message);
	}

	public BookIdMismatchException(Throwable cause) {
		super(cause);
	}

	
}
