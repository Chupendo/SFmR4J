package com.devs4j.mid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.mid.autowired.AreaTraslateService;

@SpringBootApplication
public class LoadPorpertiesApplication {

	private static final Logger log = LoggerFactory.getLogger(LoadPorpertiesApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LoadPorpertiesApplication.class, args);
		
		AreaTraslateService calculator = context.getBean(AreaTraslateService.class);
		log.info("Area total {} "+calculator.calcAreas());
	}
}
