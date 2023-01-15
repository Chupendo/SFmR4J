package com.devs4j.caching.reports;

import java.util.List;
import java.util.Optional;

import com.devs4j.caching.entitites.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByName(String name);
	public boolean existsByName(String name);
	public Optional<User> findUserByNameAndPassword(String user, String pwd);
	
	@Query("SELECT u.name FROM User u")
	public List<String> findAllUserName();
	
	@Query("SELECT u.name FROM User u")
	public Page<String> findAllUserNamePage(Pageable page);
}
