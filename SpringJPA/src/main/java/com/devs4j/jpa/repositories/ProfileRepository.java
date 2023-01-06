package com.devs4j.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.jpa.entites.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}
