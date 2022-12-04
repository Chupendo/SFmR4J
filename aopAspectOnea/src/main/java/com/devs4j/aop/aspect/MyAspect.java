package com.devs4j.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	private static final Logger log = 
			LoggerFactory.getLogger(MyAspect.class);

	@Before(value = "execution(* com.devs4j.aop.target.TargetObject.*(..))") //Advice
	public void before() {
		log.info("Before advice");
	}

}
