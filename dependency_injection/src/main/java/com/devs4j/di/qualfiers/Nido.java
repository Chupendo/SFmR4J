package com.devs4j.di.qualfiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Nido {

	private static final Logger log = LoggerFactory.getLogger(Nido.class);

	@Autowired
	@Qualifier("pajarito") //perro o pajaro
	private Animal animal;
	
	public void msg() {
		log.info("Nido {} tiene el animal "+animal);
	}
}
