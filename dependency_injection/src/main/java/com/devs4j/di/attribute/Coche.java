package com.devs4j.di.attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Coche {
	@Value("VW")
	private String marca;
	
	@Value("1981")
	private Integer modelo;
	
	@Autowired
	private Motor motor; //Dependencia

	public Coche() {


	}

	public Coche(String marca, Integer modelo, Motor motor) {
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
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

	/**
	 * @return the motor
	 */
	public Motor getMotor() {
		return motor;
	}

	/**
	 * @param motor the motor to set
	 */
	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}
	
	
	
}
