package com.devs4j.jpa.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.devs4j.jpa.entites.User;
import com.devs4j.jpa.repositories.UserRepository;
import com.github.javafaker.Faker;

@Component
public class UserRun implements ApplicationRunner {

	@Autowired
	Faker faker;
	@Autowired
	UserRepository repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("entro");
		for(int i=0;i<10000;i++) {
			User aux = new User();
			aux.setUserName(faker.name().username());
			aux.setUserNick(faker.funnyName().name());
			aux.setPassword(faker.gameOfThrones().character());
			aux.setRole(null);
			
			repository.save(aux);
		}
	}
}
