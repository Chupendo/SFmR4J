package com.devs4j.caching.reports;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.caching.entitites.Profile;


@Repository
public interface IProfileRepository extends CrudRepository<Profile, Integer> {

}
