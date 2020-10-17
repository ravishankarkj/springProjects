package com.actuatordemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemo {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String greet() {
		return "<h3>Welcome to Spring boot<h3>";
	}
	
	@GetMapping("/teamInfo")
	public String teamInfo() {
		return "Coach: "+coachName+", Team name: "+teamName; 
	}

}
