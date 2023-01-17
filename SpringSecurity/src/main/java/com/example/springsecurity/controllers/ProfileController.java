package com.example.springsecurity.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/{userdId}/profile")//un profile existe si existe un usuario
public class ProfileController {

}
