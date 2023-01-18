package com.example.springsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.entities.Address;
import com.example.springsecurity.servicies.address.AddressService;

@RestController
@RequestMapping("/users/{userId}/{profileId}/addresses")
public class AddressControllers {
	@Autowired
	AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<Address>> findAddressByProfile(
			@PathVariable("userId") Long idUser,
			@PathVariable("profileId") Long idProfile){
		
		return new ResponseEntity<List<Address>>(addressService.findAddressesByProfileAndUserId(idUser, idProfile),HttpStatus.OK);
	}

}
