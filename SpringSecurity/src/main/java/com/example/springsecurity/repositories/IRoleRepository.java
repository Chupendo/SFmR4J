package com.example.springsecurity.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
	
	Optional<Role> findRoleByName(String name); 
}
