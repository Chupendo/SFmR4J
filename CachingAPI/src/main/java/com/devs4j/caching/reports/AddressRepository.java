package com.devs4j.caching.reports;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.caching.entitites.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

}
