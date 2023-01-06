package com.devs4j.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devs4j.jpa.entites.Role;
import com.devs4j.jpa.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository repository;
	
	public List<Role> getRoles(){
		//Iterable<Role> it = repository.findAll();
		return (List<Role>) repository.findAll();
	}
}
