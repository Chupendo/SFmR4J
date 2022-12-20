package com.devs4j.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * Ejemplo de un Aspecto con un Advide "AROUND"
 * 
 * 1º Cremos un servicio "HelloWorldService.java": 
 * 2º Cremos un aspecto "AroundAdivceExmample.java": La clase esta anotada con @Component y @Aspect esto permite a spring identificarlo como un bean y como un aspecto.
 * 2.1º Creamos un advice (método) "HelloWorldService.logAround()" anotado con @Around (nos permite utilizar un Around advice).
 * Notad: Este tipo de advices reciben como parámetro un Pointcut el cual define los objetos que serán afectados por el Advice.
 * 2.2º El método recibe como parámetro un objeto que implementa la interfaz JoinPoint "ProceedingJoinPoint" (esto nos permite acceder a información del JoinPoint que se interceptó).
 *
 * En este ejmplo: Lo único que hace nuestro aspecto es:
 * a. Primero imprimir el mensaje "before advice example".
 * b. Después ejecuta el método.
 * c. Al final imprime after advice example.
 * 
 * Por tanto, los around advices interceptan la petición y deciden si ejecutar o no, 
 * esto nos permite hacer algo antes de la ejecución, después ejecutar o no el método 
 * y al final nos permite de igual modo realizar una acción.
 * 
 * @author andres.rpenuela
 *
 * into: https://devs4j.com/2019/03/29/spring-framework-5-aop-around-advice/
 */
@Aspect
@Component
public class AroundAdviceExample {

	private static final Logger log = LoggerFactory.getLogger(AroundAdviceExample.class);

	@Around("execution(void com.devs4j.aop.service.HelloWorldService.hello())")
	public void logAround(ProceedingJoinPoint pjp) {
		log.info("[AroundAdviceExample] before advice exmaple");
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("[AroundAdviceExample] after advice exmpale");
		//return result;
	}
}
