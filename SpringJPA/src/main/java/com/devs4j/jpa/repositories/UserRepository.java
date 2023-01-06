package com.devs4j.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.jpa.entites.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
