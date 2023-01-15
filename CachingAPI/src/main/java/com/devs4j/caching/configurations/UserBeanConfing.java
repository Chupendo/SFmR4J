package com.devs4j.caching.configurations;


import com.devs4j.caching.entitites.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.devs4j.caching.reports.IUserRepository;
import com.github.javafaker.Faker;

@Component
public class UserBeanConfing implements ApplicationRunner {

	
	private static final Logger log = LoggerFactory.getLogger(UserBeanConfing.class);

	@Autowired
	Faker faker;

	@Autowired
	IUserRepository uRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Setting User in Run");
		for (int i = 0; i < 10000; i++) {
			try {
				User user = new User();
				user.setName(faker.name().username());
				user.setNick(faker.dragonBall().character());
				user.setPassword(faker.funnyName().name());

				uRepo.save(user);
			} catch (Exception ex) {
				log.error(ex.toString());
				//Caused by: org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException:
				i--;
			}
		}

	}

}
