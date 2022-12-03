package com.devs4j.interfaces.bean.lazy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
@Component
public class BeanB {
	private static final Logger log = LoggerFactory.getLogger(BeanA.class);

	@PostConstruct
	public void init() {
		log.info("Init Bean B");
	}
}
