package com.example.springsecurity.controllers;

import com.example.springsecurity.entities.Profile;
import com.example.springsecurity.servicies.profiles.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}/profile")//un profile existe si existe un usuario
public class ProfileController {

    @Autowired
    ProfileService service;
    @PostMapping
    public ResponseEntity<Profile> createProfile(@PathVariable("userId") Long userId, @RequestBody Profile profile){

        return new ResponseEntity<Profile>(service.createProfile(userId,profile),HttpStatus.CREATED);
    }

    @GetMapping("/{idProfile}")
    public ResponseEntity<Profile> getProfileById(
            @PathVariable(value = "userId") Long idUser,
            @PathVariable(value = "idProfile") Long idProfile){
        return new ResponseEntity<Profile>(service.getByUserIdAndProfileId(idUser,idProfile),HttpStatus.OK);
    }
}
