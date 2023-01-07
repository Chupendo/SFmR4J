package com.devs4j.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.jpa.entites.User;
import com.devs4j.jpa.services.UserService;

@RestController
@RequestMapping("/v2/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getUser(@RequestParam(required = false,value = "startWith") String startWith){
		
		return new ResponseEntity<List<User>>(userService.getUsers(startWith),HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUsertByName(@PathVariable("username") String userName){
		return new ResponseEntity<User>(userService.getUserByName(userName),HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<User> getUsertByName(@RequestBody User user){
		
		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
	}
	
	@PutMapping("/{username}")
	public ResponseEntity<Void> getUsertByName(@PathVariable(value = "username") String userName, @RequestBody User user){
		userService.updatedUser(userName, user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{username}")
	public ResponseEntity<Void> deletedUserByName(@PathVariable(value = "username") String userName){
		userService.deleteUserByName(userName);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/auth")
	public ResponseEntity<User> authenticate(@RequestBody User user){
		
		return new ResponseEntity<User>(userService.authenticateUser(user),HttpStatus.CREATED);
	}
}
