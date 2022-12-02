package com.devs4j.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.devs4j.callback.excplictBean.ExplicitBean;
import com.devs4j.callback.lifecycle.LifeCycle;

@SpringBootApplication
public class CallBacksApplication {
	private static final Logger log = 
			LoggerFactory.getLogger(CallBacksApplication.class);

	@Bean(name = "classExtern"
			,initMethod = "init"
			,destroyMethod = "destroy")
	public ExplicitBean myBean() {
		return new ExplicitBean();
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(CallBacksApplication.class, args);
		//Esto lanza una petición de bean
		ExplicitBean bean = context.getBean(ExplicitBean.class);
		log.info("ExplicitBean {} in context"+bean.getClass());
		
		LifeCycle bean2 = context.getBean(LifeCycle.class);
		log.info("LifeCycleBean {} in context"+bean2.getClass());
		
		SpringApplication.exit(context);
	}
}
