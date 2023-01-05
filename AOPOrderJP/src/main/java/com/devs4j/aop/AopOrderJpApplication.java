package com.devs4j.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.aop.service.Operation;

@SpringBootApplication
public class AopOrderJpApplication {
	private static final Logger log = LoggerFactory.getLogger(AopOrderJpApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AopOrderJpApplication.class, args);
		Operation op = context.getBean(Operation.class);
		log.info("main() {}",op.sum(3,2));
		context.close();
	}
}