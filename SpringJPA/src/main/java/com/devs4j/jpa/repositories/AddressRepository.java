package com.devs4j.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.jpa.entites.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

}
