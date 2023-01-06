package com.devs4j.aop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.aop.models.User;
import com.github.javafaker.Faker;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

	@Autowired
	private Faker faker;

	/**
	 * Códgo para mi servicio
	 */
	private List<User> lusers = new ArrayList<User>();

	@PostConstruct
	public void init() {
		for (int i = 0; i < 100; i++) {
			lusers.add(new User(faker.dragonBall().character(), faker.funnyName().name(), faker.pokemon().name()));
		}
	}

	public List<User> getUsers() {
		return lusers;
	}

	public User getUserByName(String userName) {
		return lusers.stream().filter(u -> u.getUsername().equals(userName)).findAny()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						String.format("User %s not found", userName)));
	}

	public User createUser(User user) {
		boolean isExist = lusers.stream()
				.anyMatch(u ->
					u.getNickName().equals(user.getNickName()));
		if (isExist) {
			throw new ResponseStatusException(
					HttpStatus.CONFLICT,
					String.format("The nick %s is used", user.getNickName()));
		}
		
		lusers.add(user);
		return user;
	}
}
