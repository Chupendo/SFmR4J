package com.example.springsecurity.confings;

import com.example.springsecurity.entities.Role;
import com.example.springsecurity.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class RoleCreated  {

    public static List<Role> getLRoles() {
        List<Role> lRole = new ArrayList<>();

        lRole.add(new Role(1L,"USERS"));
        lRole.add(new Role(2L,"DEVS"));
        lRole.add(new Role(3L,"EMPLOYEE"));
        lRole.add(new Role(4L,"MANAGER"));

        return lRole;
    }
}