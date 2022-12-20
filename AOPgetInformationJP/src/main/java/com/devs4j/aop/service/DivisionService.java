package com.devs4j.aop.service;

import org.springframework.stereotype.Service;

@Service
public class DivisionService {
	
	public double div(double a,double b) {
		if(b==0)
			throw new NumberFormatException();
		
		return a/b;
	} 

}
