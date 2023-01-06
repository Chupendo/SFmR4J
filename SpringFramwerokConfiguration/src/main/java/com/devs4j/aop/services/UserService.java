package com.devs4j.aop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class UserService {

	@Autowired
	private Faker faker;
	
	/**
	 * Códgo para mi servicio
	 */
}
