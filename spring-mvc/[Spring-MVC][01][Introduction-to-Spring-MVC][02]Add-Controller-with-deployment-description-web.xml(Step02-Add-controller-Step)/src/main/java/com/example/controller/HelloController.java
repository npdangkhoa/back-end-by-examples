package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	private final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value = "/greeting")
	public String getRequest(Model model) {
		logger.info("Start method greeting");

		model.addAttribute("greeting", "Hello Controller");
		return "jsp/hello.jsp";
	}
}
