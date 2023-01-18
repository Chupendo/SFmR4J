package com.example.springsecurity.servicies.address;

import java.util.List;

import com.example.springsecurity.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.springsecurity.entities.Address;
import com.example.springsecurity.repositories.IAddressRepository;
import com.example.springsecurity.repositories.IProfileRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AddressService {

	@Autowired
	private IAddressRepository addressRepository;
	
	@Autowired
	private IProfileRepository profileRepository;

	public List<Address> findAddressesByProfileAndUserId(Long idUser, Long idProfile) {
		
		return addressRepository.findByProfileIdAndUserId(idUser, idProfile);
	}

    public Address createAddress(Long idUser, Long idProfile, Address address) {
		Profile p = profileRepository.findByUserIdAndProfileId(idUser,idProfile).orElseThrow(
				()->new ResponseStatusException(HttpStatus.NO_CONTENT,
						String.format("UserId %s or ProfileId %s not found",idUser,idProfile))
		);
		address.setProfile(p);
		return addressRepository.save(address);
    }
}
