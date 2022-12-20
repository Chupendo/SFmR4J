package com.devs4j.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * Ejemplo de un Aspecto con un Advide "Before"
 * 
 * 1º Se crea el servicio "Foo.java"
 * 2º Creamos un aspecto "BeforeAdviceExample.java", esta clase es anotada con @Component y @Aspect esto permite a spring identificarlo como un bean y como un aspecto.
 * 2.1. Creamos un advice (método) "logStartSum()" y la anotamos con @Before nos permite utilizar un Before advice.
 * 2.2. Cremos un adive (metodo) "logStartIsFactor(JoinPoint jp)" que recibe como parámetro un objeto que implementa la interfaz JoinPoint, 
 *       esto nos permite acceder a información del JoinPoint que se interceptó. 
*
* Los métodos lo único que hace es imprimir el mensaje Before advice example.
* before advice se ejecuta antes los métodos interceptados [sum(a,b);isFactor(a,b)] que se invococaron de la clase Foo.
 * 
 */
@Aspect
@Component
public class BeforeAdviceExample {

	
	private static final Logger log = LoggerFactory.getLogger(BeforeAdviceExample.class);
	
	@Before("execution(int com.devs4j.aop.service.Foo.sum(int,int))")
	public void logStartSum() {
		log.info("[BeforeAdiveExample] before advice example");
	}
	
	@Before("execution(* com.devs4j.aop.service.Foo.isFactor(int,int))")
	public void logStartIsFactor(JoinPoint jp) {
		log.info("[BeforeAdiveExample] before advice example");
		log.info("[BeforeAdiveExample] JOINPOINT:"+jp.toString()+", "+jp.getKind());
	}

}
