package com.devs4j.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping("/")
	@ApiOperation(value = "View a message", response = String.class)
	@ApiResponses(value = {@ApiResponse(code=200, message = "Successfully retrieved list")})
	public String sayHello() {
		return "Swagger Hello World";
	}
}
