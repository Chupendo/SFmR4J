package com.example.springsecurity.repositories;

import com.example.springsecurity.entities.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
	
	//public List<User> findAllUserByRole(long id);
}
