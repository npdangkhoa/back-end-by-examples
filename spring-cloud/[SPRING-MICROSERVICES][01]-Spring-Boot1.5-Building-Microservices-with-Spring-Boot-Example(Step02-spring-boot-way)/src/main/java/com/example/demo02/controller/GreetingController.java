package com.example.demo02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo03.domain.Greet;

@RestController
class GreetingController {
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> greet() {
		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}
}
