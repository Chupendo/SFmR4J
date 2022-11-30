package com.devs4j.di.inyection;

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
	private Integer modelo;
	
	public Motor() {	}

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
	@Value("1982")
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		return "Motor [marca=" + marca + ", modelo=" + modelo + "]";
	}
	
}
