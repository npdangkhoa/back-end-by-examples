package com.spring.myapp02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myapp01.domain.Greet;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public Greet sayHello() {
		return new Greet("Hello World!");
	}
}