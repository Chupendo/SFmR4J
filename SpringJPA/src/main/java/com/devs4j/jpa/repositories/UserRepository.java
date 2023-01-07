package com.devs4j.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.jpa.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findUserByUserName(String username);
	
	public Optional<User> findUserByUserNameAndPassword(String user,String pwd);
}
