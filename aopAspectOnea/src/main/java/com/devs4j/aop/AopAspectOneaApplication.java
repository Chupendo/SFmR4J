package com.devs4j.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.aop.target.TargetObject;

@SpringBootApplication
public class AopAspectOneaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context  = 
				SpringApplication.run(
						AopAspectOneaApplication.class
						, args);
		
		 TargetObject targetObject =  
				 context.getBean(TargetObject.class);
		 targetObject.hello("Hello World");
		 
		 context.close();
	}

}
