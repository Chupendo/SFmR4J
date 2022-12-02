package com.devs4j.callback.excplictBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class ExplicitBean {

	private static final Logger log = 
			LoggerFactory.getLogger(ExplicitBean.class);

	@PostConstruct
	public void init() {
		log.info("ExplicitBean {} init");
	}
	
	@PreDestroy
	public void destroy() {
		log.info("ExplicitBean {} destroy");
	}
}
