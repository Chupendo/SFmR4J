package com.devs4j.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.di.constructor.*;


@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		
		//Un contexto es un lugar donde vive los objetos contorlados por spring.
		
		Coche coche = context.getBean(Coche.class);
		System.out.println(coche);
		
		
		
	}

}
