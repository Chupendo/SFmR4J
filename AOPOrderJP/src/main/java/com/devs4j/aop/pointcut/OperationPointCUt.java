package com.devs4j.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class OperationPointCUt {
	
	@Pointcut("execution(* com.devs4j.aop.service.Operation.*(..))")
	public void advice() {	}
}
