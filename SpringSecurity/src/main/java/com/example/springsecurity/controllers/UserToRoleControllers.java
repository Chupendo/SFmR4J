package com.example.springsecurity.controllers;

import com.example.springsecurity.entities.UserToRole;
import com.example.springsecurity.servicies.usertorole.UserToRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/{userId}/{roleId}/roles")
public class UserToRoleControllers {

    @Autowired
    private UserToRoleService userToRoleService;

    @GetMapping
    public ResponseEntity<UserToRole> create(@PathVariable("userId") Long idUser,
                                            @PathVariable("roleId") Long idRole){
        return new ResponseEntity<UserToRole>(userToRoleService.create(idUser,idRole), HttpStatus.OK);
    }
}
