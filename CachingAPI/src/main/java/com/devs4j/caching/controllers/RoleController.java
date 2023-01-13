package com.devs4j.caching.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.caching.entitites.Role;
import com.devs4j.caching.services.RoleService;


@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService service;
	
	@GetMapping
	public ResponseEntity<List<Role>> getRoles(){
		return new ResponseEntity<List<Role>>(service.getRoles(),HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Role> getRoleByName(@PathVariable("name") String name){
		return new ResponseEntity<Role>(service.getRoleByName(name),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Role> createRoles(@RequestBody Role role){
		return new ResponseEntity<Role>(service.createRole(role),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Role> updatedRole(@PathVariable("id") Integer id,@RequestBody Role role){
		
		return new ResponseEntity<Role>(service.updatedRoleById(id, role),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletedRole(@PathVariable("id") Integer id,@RequestBody Role role){
		service.updatedRoleById(id, role);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
