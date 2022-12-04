package com.devs4j.bpp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.bpp.bean.BeanPostProcessorApplicationImpl;

@SpringBootApplication
public class BeanPostProcessorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BeanPostProcessorApplication.class, args);
		//context.getBean(LifeCycleBean.class);
		context.close();
	}
}
