package com.example.springsecurity.initdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.springsecurity.entities.Role;
import com.example.springsecurity.entities.User;
import com.github.javafaker.Faker;

@Component
public class InitData {
	private static final int NUSER = 1000;
	protected List<User> luser = new ArrayList<>();
	protected List<Role> lrole = new ArrayList<>();
	
	@Autowired
	private Faker faker;
	
	@PostConstruct
	public void init() {
		initListUser(NUSER);
		initListRole();
		asociateRoleToUser(NUSER/2);

	}
	
	private void initListUser(int length){
		for (int i=0;i<length;i++) {
			luser.add(new User(faker.name().name(),faker.dragonBall().character(),faker.harryPotter().character()));
		}
	}
	
	private void initListRole(){
		lrole.add(new Role(1L,"inv"));
		lrole.add(new Role(2L,"user"));
		lrole.add(new Role(3L,"admin"));
		lrole.add(new Role(4L,"super"));
	}
	
	private void asociateRoleToUser(int length) {
		Random r = new Random();
		int idRole = 0; 
		for(int i=0;i<length;i++) {
			idRole = r.nextInt(lrole.size()-1)+0; // Deuvle valores del 0 al lrole.size(), ambos includios.
			luser.get(i).setRole(lrole.get(idRole));
		}
	}
	
}
