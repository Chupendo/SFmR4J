package com.example.springsecurity.servicies.usertorole;

import com.example.springsecurity.entities.Role;
import com.example.springsecurity.entities.User;
import com.example.springsecurity.entities.UserToRole;
import com.example.springsecurity.repositories.IRoleRepository;
import com.example.springsecurity.repositories.IUserRepository;
import com.example.springsecurity.repositories.IUserToRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserToRoleService {

    @Autowired
    IUserToRoleRepository userToRoleRepository;
    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;


    public UserToRole create(Long idUser,Long idRole){
        Optional<User> user = userRepository.findById(idUser);
        Optional<Role> role = roleRepository.findById(idRole);

        if(!user.isPresent() || !role.isPresent()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,
                    String.format("idUser %s or idRole %s not found",idUser,idRole));
        }
        UserToRole utr = new UserToRole(user.get(),role.get());

        return userToRoleRepository.save(utr);
    }
}
