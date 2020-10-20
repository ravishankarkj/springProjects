package com.thymeleafdemo.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/showMyLoginPage")
	public String loginPage() {
		return "fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String errorPage() {
		return "error";
	}
}
