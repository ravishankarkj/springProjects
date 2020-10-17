package com.actuatordemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemo {
	
	@GetMapping("/")
	public String greet() {
		return "<h3>Welcome to Spring boot<h3>";
	}

}
