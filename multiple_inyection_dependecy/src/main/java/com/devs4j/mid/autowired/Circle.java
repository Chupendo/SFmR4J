package com.devs4j.mid.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure {
	//@Value("2.5")
	@Value("${circle.radius}")
	private Double side;
	
	@Override
	public double calcularArea() {
		return side*side;
	}
}
