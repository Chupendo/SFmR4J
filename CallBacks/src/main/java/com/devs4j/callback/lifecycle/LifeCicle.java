package com.devs4j.callback.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCicle implements BeanNameAware {

	private static final Logger log = LoggerFactory.getLogger(LifeCicle.class);

	@Override
	public void setBeanName(String name) {
		log.info("BeanNameAware {} " +name);
	}

}
