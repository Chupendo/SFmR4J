package com.example.springsecurity.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springsecurity.entities.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long>{

	@Query("SELECT a WHERE Address a WHERE a.profile.user.id=?1 and a.profile.id=?2")
	List<Address> findByProfileIdAndUserId(Long idUser, Long idProfile);

}
