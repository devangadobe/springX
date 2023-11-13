package com.sbfeatures.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
     
	@Value("${welcome.message}")
	String welcomeMsg;
	
	@GetMapping("/")
	public String helloMessage() {
		return welcomeMsg;
	}
	
}
