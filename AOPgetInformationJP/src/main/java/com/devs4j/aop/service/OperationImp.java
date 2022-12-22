package com.devs4j.aop.service;

import org.springframework.stereotype.Service;

@Service
public class OperationImp implements IOperation {
	@Override
	public int sum(int a, int b) {
		
		return a+b;
	}
}
