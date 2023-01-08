package com.devs4j.swaggerapi.controllers;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersControllers {

    @GetMapping
    @Timed("get.users")
    public String getUsers(){
        return "Hola world!";
    }
}
