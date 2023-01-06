package com.devs4j.aop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class Devs4jController {

	@GetMapping //method handler
	public String home() {
		//resource
		return "¡Hello World!";
	}
}
