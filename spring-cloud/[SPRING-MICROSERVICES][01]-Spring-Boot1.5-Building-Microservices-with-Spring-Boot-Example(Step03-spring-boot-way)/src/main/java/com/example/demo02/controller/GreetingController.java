package com.example.demo02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo03.domain.Greet;

@RestController
class GreetingController {
	
	@RequestMapping(value = "/")
	public Greet greet() {
		return new Greet("Hello World!");
	}
}
