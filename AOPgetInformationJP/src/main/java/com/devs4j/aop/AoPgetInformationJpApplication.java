package com.devs4j.aop;

import java.rmi.server.Operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.aop.service.IOperation;
import com.devs4j.aop.service.OperationImp;

@SpringBootApplication
public class AoPgetInformationJpApplication {

	private static final Logger log = LoggerFactory.getLogger(AoPgetInformationJpApplication.class);

	public static void main(String[] args) {
		 ConfigurableApplicationContext context = SpringApplication.run(AoPgetInformationJpApplication.class, args);
		 
		 IOperation serv =  context.getBean(OperationImp.class);
		 
		 log.info("Suma(2,3)= "+serv.sum(2, 3));
		 
		 context.close();
	}

}
