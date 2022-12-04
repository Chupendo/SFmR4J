package com.devs4j.bpp.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanPostProcessorApplicationImpl implements 
BeanNameAware, BeanPostProcessor {

	private static final Logger log = 
			LoggerFactory.getLogger(
					BeanPostProcessorApplicationImpl.class);

	@Override
	public void setBeanName(String name) {
		log.info("BeanPostProcessorApplicationImpl {} name "+name);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean,
			String beanName) throws BeansException {
		log.info("Bean initialization {} "+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, 
			String beanName) throws BeansException {
		log.info("After initialization {} "+beanName);
		return bean;
	}

	
}
