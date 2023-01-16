package com.example.springsecurity.initdata;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.springsecurity.repositories.IRoleRepository;
import com.example.springsecurity.repositories.IUserRepository;

@Component
public class LoadDataInRun implements ApplicationRunner {
	
	@Autowired
	IRoleRepository roleRepo;
	
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	InitData data;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		roleRepo.saveAll(data.lrole);
		userRepo.saveAll(data.luser);

	}
}
