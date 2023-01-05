package com.devs4j.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;


public class OperationPointCUt {
	//@Pointcut("execution(* com.devs4j.aop.service.Operation.*(..))")
	//@Pointcut("within(com.devs4j.aop.service.*")
	//@Pointcut("within(com.devs4j.aop.service.Operation)")
	@Pointcut("@annotation(com.devs4j.aop.annotation.Devs4j)")
	public void advice() {	}
}
