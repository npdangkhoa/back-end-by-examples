package com.example.demo02.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo03.domain.Greet;

@RestController
class GreetingController {
	
	@Autowired
	Environment env;
	
	@ResponseBody
	@RequestMapping(value = "/greet")
	@CrossOrigin(origins="http://localhost:8080", maxAge=6000, allowCredentials = "true")
	public HttpEntity<Greet> greet(@RequestParam(value = "name", required = false, defaultValue="HATEOAS" ) String name) {

		String profile = env.getProperty("spring.profiles.active");
		
		Greet greet = new Greet("Hello " + profile);
		greet.add(linkTo(methodOn(GreetingController.class).greet(profile)).withSelfRel());

		return new ResponseEntity<Greet>(greet, HttpStatus.OK);
	}
}
