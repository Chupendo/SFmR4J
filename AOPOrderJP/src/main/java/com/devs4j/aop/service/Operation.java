package com.devs4j.aop.service;

import org.springframework.stereotype.Service;

import com.devs4j.aop.annotation.Devs4j;

@Service
public class Operation {

	public int sum(int a, int b) {
		return a+b;
	}
	
	@Devs4j
	public int subtrac(int a, int b) {
		return a-b;
	}
}
