package com.devs4j.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.jpa.models.User;
import com.github.javafaker.Faker;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceUsingList {
	
	@Autowired
	Faker faker;
	
	public static List<User> luser = new ArrayList<User>();
	
	@PostConstruct
	private void init() {
		for(int i=0;i<100;i++) {
			luser.add(new User(
					faker.pokemon().name(),
					faker.dragonBall().character(),
					faker.funnyName().name()));
		}
	}
	
	public List<User> getUsers(String startWith){
		if(startWith==null) {
			return luser;
		}
		return luser.stream().filter(u->u.getUserName().startsWith(startWith)).collect(Collectors.toList());
	}
	
	public User getUserByName(String userName){
		return luser.stream().filter(u->u.getUserName().equals(userName))
				.findAny()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, 
				String.format("User %s not found", userName)));
	}
	
	public User createUser(User user){
		if(luser.stream().anyMatch(u->u.getUserName().equals(user.getUserName()))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					String.format("The %s is in used", user.getUserName()));
		}
		
		luser.add(user);
		return user;
	}
	
	public void updatedUser(String userName,User user) {
		User userToBeUpdated = getUserByName(userName);
		if(!userName.equals(user.getUserNick()))
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, 
					String.format("The %s don't equal to %s",userName,user.getUserName()));
		
		userToBeUpdated.setUserNick(user.getUserNick());
		userToBeUpdated.setPassword(user.getPassword());
	}
	
	public void deleteUserByName(String userName) {
		User userToBeDeleted = getUserByName(userName);
		
		luser.remove(userToBeDeleted);
	}

}
