package com.devs4j.mid.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure {

	@Value("2.5")
	private double radius;
	
	@Override
	public double calcularArea() {
		return 2*Math.PI*radius;
	}
}
