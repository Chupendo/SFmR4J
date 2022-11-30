package com.devs4j.di.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Coche {
	private String marca;
	private Integer modelo;
	private Motor motor; //Dependencia

	public Coche() {}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	@Value("VW") 
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
	@Value("1981")
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the motor
	 */
	public Motor getMoto2r() {
		return motor;
	}

	/**
	 * @param motor the motor to set
	 */
	@Autowired
	public void setMotor2(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}	
}
