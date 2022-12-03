package com.devs4j.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.interfaces.lifeCycle.LifeCycleBean;

@SpringBootApplication
public class InitializingBeanDisposiableBeanApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context =  
				 SpringApplication.run(
						 InitializingBeanDisposiableBeanApplication.class
						 , args);
		 //context.getBean(LifeCycleBean.class);
		 context.close();
	}

}
