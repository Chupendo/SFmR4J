package com.devs4j.di.qualfiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pajarito")
public class Pajaro extends Animal implements IVolador{
	public static final Logger log = LoggerFactory.getLogger(Pajaro.class);
	
	public Pajaro(@Value("Pajaro Loco") String nombre,@Value("2") Integer edad) {
		super(nombre, edad);
	}
	
	@Override
	public void volar() {
		log.info("Se volar");		
	}
	
	@Override
	public String toString() {
		return "Pajaro [getNombre()=" + getNombre() + ", getEdad()=" + getEdad() + "]";
	}
}
