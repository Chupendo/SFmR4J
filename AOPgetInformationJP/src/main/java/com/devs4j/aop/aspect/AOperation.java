package com.devs4j.aop.aspect;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
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
	public void aOper(JoinPoint joinPoint) {
		Signature signautre = joinPoint.getSignature();
		log.info("[AOperation] before operation start");
		log.info("Firma del JoinPoint:\n"
				+joinPoint.getSignature().toLongString());
		log.info("Nombre: {}", signautre.getName());
		log.info("Modifiers: {}", signautre.getModifiers());
		log.info("is pubblic: {}", Modifier.isPublic(signautre.getModifiers()));
		log.info("Return type: {}", signautre.getDeclaringTypeName());
		log.info("Args: {}",joinPoint.getArgs());
		log.info("[AOperation] before operation end");
	}
}
