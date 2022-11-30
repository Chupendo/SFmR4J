package com.devs4j.di.qualfiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Avion implements IVolador{
	
	private static final Logger log = LoggerFactory.getLogger(Avion.class);

	@Override
	public void volar() {
		log.info("Vuelo");
	}
	
	@Override
	public String toString() {
		return "Soy un Avion";
	}
}
