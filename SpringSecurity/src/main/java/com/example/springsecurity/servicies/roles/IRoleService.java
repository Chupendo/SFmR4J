package com.example.springsecurity.servicies.roles;

import java.util.List;

import com.example.springsecurity.entities.Role;

public interface IRoleService {

	List<Role> getAllRole(String contain);
	Role getRolleByName(String name);
	Role getRolleById(Integer id);
	
	Role createRole(Role role);
	
	Role updateRoleById(long id,Role roleNew);
	Role updateRoleByName(String nameOld, Role roleNew);
	
	
	boolean deleteRoleById(long l);
	boolean deleteRoleByName(String name);
		
}
