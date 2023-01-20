package com.example.springsecurity.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/home")
    public String home(){
        return "view home";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "view welcome";
    }
    @GetMapping("/admin")
    public String admin(){
        return "view admin";
    }
    @GetMapping("/emp")
    public String emp(){
        return "view emp";
    }
    @GetMapping("/mgr")
    public String mgr(){
        return "view mgr";
    }
    @GetMapping("/common")
    public String common(){
        return "view common";
    }

    @GetMapping("/logout")
    public String logout(){
        return "view logout";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "view accessDenied";
    }
}
