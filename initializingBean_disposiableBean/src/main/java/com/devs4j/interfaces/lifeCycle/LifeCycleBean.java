package com.devs4j.interfaces.lifeCycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy //@Lazy(false) //Lo pongo como lazy para probar segundo ejemplo
public class LifeCycleBean implements BeanNameAware, 
	InitializingBean, DisposableBean {

	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);
	
	@PostConstruct
	public void init() {
		log.info("LifeCycleBean {} Post Constructor)");
	}
	/**
	 * Method of InitializingBean equal to @PostConstructor
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("LifeCycleBean {} Initalizing Bean");

	}

	/**
	 * Method of BeanNameAware
	 * Lanch a event to create a bean of this class
	 */
	@Override
	public void setBeanName(String name) {
		log.info("LifeCycleanBean {} name = "+name);
		
	}
	
	/**
	 * Method of DisposableBean equals to @PreDestory
	 */
	@Override
	public void destroy() throws Exception {
		log.info("LifyeCycleBean {} DisposableBean");

	}

	@PreDestroy
	public void destroy2() {
		log.info("LifyeCycleBean {} Pre Destroy");
	}
}
