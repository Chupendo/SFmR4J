package com.devs4j.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanExcplitApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BeanExcplitApplication.class);

	//Ejemplo de definicon de un bien expliciot
	@Bean
	public static String getNombreApp() {
		return "BeanExcplitApplication";
	} 
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BeanExcplitApplication.class, args);
		
		String nameApp = context.getBean(String.class);
		log.info("Bean String {} "+nameApp);
	}

}
