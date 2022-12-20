package com.devs4j.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * Ejemplo de un Aspecto con un Advide "After Throwing"
 * 
 * 1º Creamos el servcio "DivisionService.java"
 * 2º Cremoas un aspecto "AfterThrowingAdiveExample.java" y lo anotamos la clase con @Component y @Aspect esto permite a spring identificarlo como un bean y como un aspecto.
 * 2.1. Definimos un advice (metodo) y lo anotmoas con @AfterThrowing, esto nos permite utilizar un After throwing advice, además,
 * 		los advices reciben como parámetro un Pointcut el cual define los objetos que serán afectados por el Advice (su definición es opcionalmente),
 * 		esto nos permite acceder a información del JoinPoint que se interceptó.
 * 
 * Lo único que hace nuestro aspecto es imprimir el mensaje After throwing example
 * Los Advices After throwing se ejecutan después de que se ejecutó el método interceptado siempre y cuando haya habido una excepción y antes de tratarse la
 * excepción por el manejador.
 * 
 * @author andres.rpenuela
 *
 */
@Aspect
@Component
public class AfterThrowingAdviceExample {

	
	private static final Logger log = LoggerFactory.getLogger(AfterThrowingAdviceExample.class);


	@AfterThrowing("execution(* com.devs4j.aop.service.DivisionService.*(..))")
	public void logAfterThrowing(JoinPoint joinPoint) {
		log.info("After throwing example");
		log.info(joinPoint.toString()+", "+joinPoint.getKind());
	}
}
