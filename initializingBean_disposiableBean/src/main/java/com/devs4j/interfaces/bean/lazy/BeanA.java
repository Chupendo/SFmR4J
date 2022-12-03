package com.devs4j.interfaces.bean.lazy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
@Component @Lazy
public class BeanA {
	private static final Logger log = LoggerFactory.getLogger(BeanA.class);
	@Autowired
	private BeanB bean;
	@PostConstruct
	public void init() {
		log.info("Init Bean A");
	}
}