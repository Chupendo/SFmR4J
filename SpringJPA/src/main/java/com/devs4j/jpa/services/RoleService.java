package com.devs4j.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
	
	public Role getRoleByName(String name) {
		Role role = repository.findByName(name);
		if(role==null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					String.format("The %s don't found",name));
		
		return role;
	}
	
	public Role getRoleById(Integer id) {

		return repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(
						HttpStatus.BAD_REQUEST, 
						String.format("The %s not found",id)));
	}
	
	public Role createRole(Role role) {
		if(repository.findByName(role.getName())!=null ) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					String.format("The %s is used",role.getName()));
		}
	
		repository.save(role);
		return role;
	}
	
	public boolean idRoleInUsed(Integer id) {
		return repository.existsById(id);
	}
	
	public Role updatedRoleById(Integer id,Role role) {
		if(repository.findByName(role.getName())!=null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, 
					String.format("The %s is used",role.getName()));
		}
		
		Role roleToByUpdate = getRoleById(id);
		roleToByUpdate.setName(role.getName());
		repository.save(roleToByUpdate);
		return roleToByUpdate;
	}
	
	public void deletedRoleById(Integer id) {
		if(!idRoleInUsed(id))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					String.format("The %s not found",id));
		repository.deleteById(id);
	}
}
