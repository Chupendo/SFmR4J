package com.devs4j.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOperation {
	
	private static final Logger log = LoggerFactory.getLogger(AOperation.class);

	@Before(value = "execution(* com.devs4j.aop.service.OperationImp.*(..))")
	public void aOper() {
		log.info("[AOperation] before operation ");
	}
}
