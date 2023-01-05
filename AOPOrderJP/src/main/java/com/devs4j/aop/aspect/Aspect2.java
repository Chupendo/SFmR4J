package com.devs4j.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class Aspect2 {
	private static final Logger log = LoggerFactory.getLogger(Aspect2.class);
	@Before("execution(* com.devs4j.aop.service.Operation.*(..))")
	public void advice(JoinPoint jpt) {
		log.info("before advice Aspect2 {} ",jpt.getSignature().getName());
	}
}
