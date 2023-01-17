package com.example.springsecurity.servicies.profiles;

import com.example.springsecurity.entities.Profile;
import com.example.springsecurity.repositories.IProfileRepository;
import com.example.springsecurity.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProfileService {
    @Autowired
    IProfileRepository profileRepo;

    @Autowired
    IUserRepository userRepo;

    public Profile createProfile(Long userId, Profile profile){
        profile.setUser(userRepo.findById(userId).orElseThrow(()->new ResponseStatusException(HttpStatus.NO_CONTENT,
                String.format("usr id %s not found",userId))));
        return profileRepo.save(profile);
    }


    public Profile getByUserIdAndProfileId(Long idUser,Long idProfile){
        return profileRepo.findByUserIdAndProfileId(idUser,idProfile).orElseThrow(()->new ResponseStatusException(HttpStatus.NO_CONTENT,
                String.format("user id %s or profile id %s not found",idUser,idProfile)));
    }
}
