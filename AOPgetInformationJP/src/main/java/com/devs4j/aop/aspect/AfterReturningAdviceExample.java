package com.devs4j.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * Ejemplo de After Returning Advice
 * 
 * 1º Crear el servicio "HelloWorldService2.java"
 * 2º Crear un ascepto "AfterReturningAdviceExample.java", la clase esta anotada con @Component y @Aspect esto permite a spring identificarlo como un bean y como un aspecto.
 * 2.1º Crear un advice (método) "logEndHello(JoinPoint jp)"m, anotado con @AfterReturning, esto nos permite utilizar un After returning advice.
 *      Todos los advices reciben como parámetro un Pointcut el cual define los objetos que serán afectados por el Advice (opcional), 
 *      esto nos permite acceder a información del JoinPoint que se interceptó.
 *      
 * Lo único que hace nuestro aspecto es imprimir el mensaje After returning example
 * Los Advices After returning se ejecutan después de que se ejecutó el método interceptado siempre y cuando no haya habido una excepción.
 * @author andres.rpenuela
 *
 */
@Aspect
@Component
public class AfterReturningAdviceExample {
	
	private static final Logger log = LoggerFactory.getLogger(AfterReturningAdviceExample.class);

	@AfterReturning("execution(* com.devs4j.aop.service.HelloWorldService2.*(..))")
	public void logEndHello(/*JoinPoint jp*/) {
		log.info("[AfterReturningAdiveExample] after returning advice example");
	}
}
