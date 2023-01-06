package com.devs4j.aop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.aop.models.User;
import com.devs4j.aop.services.UserService;

@RestController
@RequestMapping("/user")
class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(userService.getUsers(),HttpStatus.OK);
	}
}
