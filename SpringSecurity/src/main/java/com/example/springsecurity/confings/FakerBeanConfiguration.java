package com.example.springsecurity.confings;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerBeanConfiguration {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}