package com.devs4j.di.qualfiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Perro extends Animal{

	public Perro(@Value("Rocky")String nombre,@Value("1") Integer edad) {
		super(nombre, edad);
	}

	@Override
	public String toString() {
		return "Perro [getNombre()=" + getNombre() + ", getEdad()=" + getEdad() + "]";
	}
}
