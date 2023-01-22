package com.example.springsecurity.confings;


import com.example.springsecurity.entities.Role;
import com.example.springsecurity.entities.User;
import com.example.springsecurity.entities.UserToRole;
import com.example.springsecurity.repositories.IRoleRepository;
import com.example.springsecurity.repositories.IUserRepository;
import com.example.springsecurity.repositories.IUserToRoleRepository;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;


@Component
public class UserBeanConfing implements ApplicationRunner {


    private static final Logger log = LoggerFactory.getLogger(UserBeanConfing.class);

    @Autowired
    Faker faker;

    @Autowired
    IUserRepository uRepo;

    @Autowired
    IRoleRepository rRepo;

    @Autowired
    IUserToRoleRepository utorRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Setting User in Run");
        List<Role> roles = RoleCreated.getLRoles();

        for (Role r: roles) {
           rRepo.save(r);
        }

        for (int i = 0; i < 10000; i++) {
            try {
                User user = new User();
                user.setUserName("andres"+i);//faker.name().name());
                user.setUserNick(faker.dragonBall().character());
                user.setPassword("123");//faker.funnyName().name());

                user = uRepo.save(user);

                UserToRole utor = new UserToRole(user,roles.get((new Random()).nextInt(roles.size())));
                utorRepo.save(utor);
            } catch (Exception ex) {
                log.error(ex.toString());
                //Caused by: org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException:
                i--;
            }
        }
    }
}