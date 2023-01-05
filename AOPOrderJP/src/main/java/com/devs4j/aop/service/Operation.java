package com.devs4j.aop.service;

import org.springframework.stereotype.Service;

@Service
public class Operation {

	public int sum(int a, int b) {
		return a+b;
	}
}
