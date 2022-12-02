package com.devs4j.callback.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("prototype") //Camibo de Scope
public class LifeCycle implements BeanNameAware {

	private static final Logger log = LoggerFactory.getLogger(LifeCycle.class);

	@PostConstruct
	public void initBean() {
		log.info("LifeCycle {} init ");
	}
	
	@Override
	public void setBeanName(String name) {
		log.info("BeanNameAware {} " +name);
	}
	//Este método no se lanza en bean prototype
	@PreDestroy
	public void destoyBean() {
		log.info("LifyCycle {} destroy ");
	}
}
