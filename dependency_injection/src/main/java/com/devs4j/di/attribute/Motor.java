package com.devs4j.di.attribute;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author andres.rpenuela
 *
 */
@Component
public class Motor {
	@Value("Xl1")
	private String marca;
	
	@Value("1982")
	private Integer modelo;
	
	public Motor() {
		
	}
	public Motor(String marca, Integer modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public Integer getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		return "Motor [marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}
