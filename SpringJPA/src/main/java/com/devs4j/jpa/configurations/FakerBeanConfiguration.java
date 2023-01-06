package com.devs4j.jpa.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class FakerBeanConfiguration {
	
	@Bean
	public Faker getFaker() {
		return new Faker();
	}

}
