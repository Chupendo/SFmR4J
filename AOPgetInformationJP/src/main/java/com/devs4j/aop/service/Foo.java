package com.devs4j.aop.service;

import org.springframework.stereotype.Service;

@Service
public class Foo {
	
	public boolean isFactor(int a,int b) {
		return (a%b==0)?true:false;
	}
	
	public int sum(int a,int b) {
		return a+b;
	}
	
	
	
}
