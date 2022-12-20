package com.devs4j.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.aop.service.DivisionService;
import com.devs4j.aop.service.Foo;
import com.devs4j.aop.service.HelloWorldService;
import com.devs4j.aop.service.HelloWorldService2;


@SpringBootApplication
public class AoPgetInformationJpApplication {

	
	private static final Logger log = LoggerFactory.getLogger(AoPgetInformationJpApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AoPgetInformationJpApplication.class, args);
		
		//Ejemplo de around advice
		HelloWorldService helloWorldService = context.getBean(HelloWorldService.class);
		helloWorldService.hello();
		log.info("---------------------------------------------------------------------");
		//Ejemplo de before advice
		Foo fooService = context.getBean(Foo.class);
		log.info("Sum(2,3): "+ fooService.sum(2, 3));
		log.info("isFacot(2,3): "+ fooService.isFactor(2, 3));
		log.info("---------------------------------------------------------------------");
		//Ejemplo de after throwing advice
		DivisionService divService = context.getBean(DivisionService.class);
		log.info("Div(2,3): "+ divService.div(2, 3));
		
		try {
		log.info("Div(2,0): "+ divService.div(2, 0));
		}catch (Exception e) {
			log.error("Error: "+e);
		}
		log.info("---------------------------------------------------------------------");
		//Ejemplo de after returning advice
		HelloWorldService2 helloWorldService2 = context.getBean(HelloWorldService2.class);
		helloWorldService2.hello();
		
		context.close();
	}

}
