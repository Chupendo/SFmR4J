package com.devs4j.swaggerapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersControllers {

    @GetMapping
    public String getUsers(){
        return "Hola world!";
    }
}
