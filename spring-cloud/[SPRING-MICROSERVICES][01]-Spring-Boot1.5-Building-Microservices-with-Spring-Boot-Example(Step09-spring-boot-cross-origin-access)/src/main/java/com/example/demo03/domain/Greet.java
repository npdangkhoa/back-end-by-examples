package com.example.demo03.domain;

import org.springframework.hateoas.ResourceSupport;

public class Greet extends ResourceSupport {
	private String message;

	public Greet() {
	}

	public Greet(String message) {
		this.message = message;
	}
	// add getter and setter

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
