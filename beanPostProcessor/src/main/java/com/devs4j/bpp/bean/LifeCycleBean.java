package com.devs4j.bpp.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class LifeCycleBean implements BeanNameAware{
	
	private static final Logger log = LoggerFactory.getLogger(
			LifeCycleBean.class);


	@Override
	public void setBeanName(String name) {
		log.info("LifeCycleBean {} "+name);	
	}
	
	@PostConstruct
	public void init() {
		log.info("LifeCycleBean {} PostConstructor");
	}
	
	@PreDestroy
	public void delete() {
		log.info("LifeCycleBean {} PreDestroy");
	}

}
