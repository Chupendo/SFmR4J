package com.devs4j.caching.controllers;

import java.util.List;

import com.devs4j.caching.entitites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.devs4j.caching.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService uSer;
	
	@GetMapping
	public ResponseEntity<List<User>> getUser(@RequestParam(required = false, value = "startWith") String startWith) {

		return new ResponseEntity<List<User>>(uSer.getUsers(startWith), HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<User> getUsertByName(@PathVariable("username") String userName) {
		return new ResponseEntity<User>(uSer.getUserByName(userName), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> getUsertByName(@RequestBody User user) {

		return new ResponseEntity<User>(uSer.createUser(user), HttpStatus.CREATED);
	}

	@PutMapping("/{username}")
	public ResponseEntity<Void> getUsertByName(@PathVariable(value = "username") String userName,
			@RequestBody User user) {
		uSer.updateUser(userName, user);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{username}")
	public ResponseEntity<Void> deletedUserByName(@PathVariable(value = "username") String userName) {
		uSer.deleteUserByName(userName);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/auth")
	public ResponseEntity<User> authenticate(@RequestBody User user) {

		return new ResponseEntity<User>(uSer.authenticateUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/pagination")
	public ResponseEntity<Page<User>> getUserPaginable(
			@RequestParam("page") Integer page, 
			@RequestParam("size") Integer size, 
			@RequestParam(required = false, value = "startWith") String startWith) {
		return new ResponseEntity<Page<User>>(uSer.getUsersPage(page,size,startWith), HttpStatus.OK);
	}
	
	@GetMapping("/usernames")
	public ResponseEntity<List<String>> getAllUserNames() {

		return new ResponseEntity<List<String>>(uSer.getAllUserNames(), HttpStatus.OK);
	}
	
	@GetMapping("/usernames-page")
	public ResponseEntity<Page<String>> getAllUserNamesPage(
			@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
			@RequestParam(required = false, value = "size", defaultValue = "10") Integer size) {
		

		return new ResponseEntity<Page<String>>(uSer.getAllUserNamesPage(page,size), HttpStatus.OK);
	}
	
}
