package com.devs4j.aop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		for (int i=0;i<100;i++) {
			lusers.add(new User(faker.dragonBall().character(),faker.funnyName().name(),faker.pokemon().name()));
		}
	}
	
	public List<User> getUsers(){
		return lusers;
	}
}
