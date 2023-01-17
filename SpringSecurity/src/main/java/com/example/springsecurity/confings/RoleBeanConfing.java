package com.example.springsecurity.confings;

import com.example.springsecurity.entities.Role;
import com.example.springsecurity.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleBeanConfing implements ApplicationRunner {

    @Autowired
    IRoleRepository repo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Role> lRole = new ArrayList<>();

        lRole.add(new Role(1L,"user"));
        lRole.add(new Role(2L,"dev"));
        lRole.add(new Role(3L,"admin"));
        lRole.add(new Role(4L,"super"));

        repo.saveAll(lRole);
    }
}