package com.example.springsecurity.servicies.roles.users;

import com.example.springsecurity.entities.User;
import com.example.springsecurity.entities.UserToRole;
import com.example.springsecurity.repositories.IUserRepository;
import com.example.springsecurity.repositories.IUserToRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    private static final String TAG = "UserDetailService";
    private static final Logger log = LoggerFactory.getLogger(TAG);
    @Autowired
    private IUserRepository uRepo;

    @Autowired
    private IUserToRoleRepository utrRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = uRepo.findByUserName(username);
        if(optUser.isPresent()){
            User user = optUser.get();
            List<UserToRole> roles = utrRepo.findByUser(user);

            String role[] = roles.stream().map(r->r.getRole().getName()).toArray(String[]::new);
            for (String r:role) {
                log.info("roles {}"+r);
            }

            return org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
                    //.password(passwordEncoder().encode(user.getPassword()))
                    .password(passwordEncoder.encode(user.getPassword()))
                    .roles(role)
                    .build();
        }else{
            throw new UsernameNotFoundException("Username "+username+" not found");
        }
    }

    /*
    //Bean create in SurityJavBeanCondfiguration yet
    @Bean
    public PasswordEncoder passwordEncoders(){
        return new BCryptPasswordEncoder();
    }
    */
}
