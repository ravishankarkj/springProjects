package com.thymeleafdemo.thymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {

	@GetMapping("/hello")
	public String hello(Model theModel) {
		theModel.addAttribute("theDate", new Date());
		return "helloworld";
	}
}
