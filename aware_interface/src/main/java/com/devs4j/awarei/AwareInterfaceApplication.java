package com.devs4j.awarei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.devs4j.awarei.lifecycle.LifeCycleBean;

@SpringBootApplication
public class AwareInterfaceApplication {

	private static final Logger log = 
			LoggerFactory.getLogger(AwareInterfaceApplication.class);

	@Bean
	@Primary
	public String nameAppBean() {
		return "Aware Interface Example";
	}
	
	@Bean("bean2")
	public String beanExplcit() {
		return "Bean of type String";
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext context =  
				SpringApplication.run(AwareInterfaceApplication.class, args);
		LifeCycleBean bean = context.getBean(LifeCycleBean.class);
		
		String beanStr = context.getBean("bean2",String.class);
		log.info(beanStr.toUpperCase());
	}
}
