package com.devs4j.caching.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.devs4j.caching.entitites.Role;
import com.devs4j.caching.reports.IRoleRepository;

@Component
public class RoleBeanConfing implements ApplicationRunner{

	@Autowired
	IRoleRepository repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Role> lRole = new ArrayList<Role>();
		
		lRole.add(new Role("user"));
		lRole.add(new Role("dev"));
		lRole.add(new Role("admin"));
		lRole.add(new Role("super"));
		
		repo.saveAll(lRole);
	}
}
