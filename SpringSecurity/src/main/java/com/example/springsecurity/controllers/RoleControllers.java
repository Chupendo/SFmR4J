package com.example.springsecurity.controllers;

import java.util.List;

import com.example.springsecurity.entities.User;
import com.example.springsecurity.repositories.IUserToRoleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.entities.Role;
import com.example.springsecurity.servicies.roles.IRoleService;

@RestController
@RequestMapping("/roles")
public class RoleControllers {

	@Autowired
	IRoleService rs;

	@Autowired
	private IUserToRoleRepository utrRepo;

	@GetMapping
	public ResponseEntity<List<Role>> getAllRoles(@RequestParam(value="contain",required = false) String contain){
		return new ResponseEntity<List<Role>>(rs.getAllRole(contain),HttpStatus.OK);
	}

	@GetMapping("/{nameRole}/users")
	public ResponseEntity<List<User>> getUserByRole(@PathVariable(value= "nameRole") String nameRole){
		return new ResponseEntity<List<User>>(utrRepo.findUserByRoleName(nameRole),HttpStatus.OK);
	}

	@GetMapping("/{name}")
	public ResponseEntity<Role> getRoleByName(@PathVariable(value = "name") String name){
		return new ResponseEntity<Role>(rs.getRolleByName(name),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Role> addRole(@RequestBody Role role){
		return new ResponseEntity<Role>(rs.createRole(role),HttpStatus.OK);
	}
	
	@DeleteMapping("/{param}")
	public ResponseEntity<Void> deleteByIdOrName(@PathVariable(value = "param") String param){
		if(StringUtils.isNumeric(param)) {
			rs.deleteRoleById(Long.parseLong(param)); 
		}
			rs.deleteRoleByName(param);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
