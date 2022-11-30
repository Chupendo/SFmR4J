package com.devs4j.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.profiles.conf.IEnviroment;

@SpringBootApplication
public class ControlPriflesApplication {

	private static final Logger log = LoggerFactory.getLogger(ControlPriflesApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(ControlPriflesApplication.class, args);
		
		IEnviroment env = context.getBean(IEnviroment.class);
		log.info(env.getEnviroment());
	}

}
