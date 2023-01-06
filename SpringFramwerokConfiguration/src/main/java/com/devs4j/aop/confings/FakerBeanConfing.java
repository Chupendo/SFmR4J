package com.devs4j.aop.confings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class FakerBeanConfing {

	@Bean
	public Faker getFaker() {
		return new Faker();
	}
}
