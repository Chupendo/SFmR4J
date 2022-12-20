package com.devs4j.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService2 {

	
	private static final Logger log = LoggerFactory.getLogger(HelloWorldService2.class);
	
	public void hello() {
		log.info("Hello World");
	}
}
