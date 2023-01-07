package com.devs4j.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devs4j.jpa.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findUserByUserName(String username);
	
	public Optional<User> findUserByUserNameAndPassword(String user,String pwd);
	
	@Query("SELECT u.userName FROM User u")
	public List<String> findAllUserNames();
	
	@Query("SELECT u.userName FROM User u")
	public Page<String> findAllUserNamesPage(Pageable page);
}
