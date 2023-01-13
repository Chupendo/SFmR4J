package com.devs4j.caching.reports;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.caching.entitites.Role;


@Repository
public interface IRoleRepository extends CrudRepository<Role, Integer> {

	public Role findByName(String name);
}
