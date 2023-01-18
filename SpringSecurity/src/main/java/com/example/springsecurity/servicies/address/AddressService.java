package com.example.springsecurity.servicies.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springsecurity.entities.Address;
import com.example.springsecurity.repositories.IAddressRepository;
import com.example.springsecurity.repositories.IProfileRepository;

@Service
public class AddressService {

	@Autowired
	private IAddressRepository addressRepository;
	
	@Autowired
	private IProfileRepository profileRepository;

	public List<Address> findAddressesByProfileAndUserId(Long idUser, Long idProfile) {
		
		return addressRepository.findByProfileIdAndUserId(idUser, idProfile);
	}
}
