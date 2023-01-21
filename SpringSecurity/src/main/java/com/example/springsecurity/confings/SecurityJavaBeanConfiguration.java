package com.example.springsecurity.confings;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityJavaBeanConfiguration  {

    @Bean
    protected InMemoryUserDetailsManager configAuthentication() {
        //Create user and role
        //Note: If you want to store the password as plaintext you will have to prefix it with {noop}
        List<UserDetails> users = new ArrayList<>();
        List<GrantedAuthority> adminAuthority = new ArrayList<>();
        adminAuthority.add(new SimpleGrantedAuthority("ADMIN"));
        //UserDetails admin= new User("devs", "{noop}devs", adminAuthority);
        UserDetails admin= new User("devs", encode().encode("vs"), adminAuthority);
        users.add(admin);

        List<GrantedAuthority> employeeAuthority = new ArrayList<>();
        adminAuthority.add(new SimpleGrantedAuthority("EMPLOYEE"));
        //UserDetails employee= new User("ns", "{noop}ns", employeeAuthority);
        UserDetails employee= new User("ns", encode().encode("vs"), adminAuthority);
        users.add(employee);

        List<GrantedAuthority> managerAuthority = new ArrayList<>();
        adminAuthority.add(new SimpleGrantedAuthority("MANAGER"));
        UserDetails manager= new User("vs", encode().encode("vs"), managerAuthority);
        users.add(manager);

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //declares which Page(URL) will have What access type
        http
                .csrf().disable()
                .authorizeRequests()

                .and()
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/welcome").authenticated()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/emp").hasAuthority("EMPLOYEE")
                .antMatchers("/mgr").hasAuthority("MANAGER")
                .antMatchers("/common").hasAnyAuthority("EMPLOYEE","MANAGER")
                .antMatchers("/roles/**").hasAnyAuthority("EMPLOYEE","MANAGER")

                //Habilitamos peitonces/respusta de h2-consoel
                .and()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .and()
                .headers().frameOptions().disable()

                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.POST,"/user").hasAnyAuthority("EMPLOYEE","MANAGER")
                .antMatchers(HttpMethod.PUT).permitAll()
                .antMatchers(HttpMethod.DELETE).permitAll()

                // Any other URLs which are not configured in above antMatchers
                // generally declared aunthenticated() in real time
                //.anyRequest().authenticated()
                .anyRequest().hasAuthority("MANAGER")
                // Login Form Details
                .and()
                .formLogin()
                .defaultSuccessUrl("/welcome", true)

                // Logout Form Details
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                // Exception Details
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")

                .and()
                .httpBasic();

        ;
        return http.build();
    }

    @Bean
    public PasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }
}
