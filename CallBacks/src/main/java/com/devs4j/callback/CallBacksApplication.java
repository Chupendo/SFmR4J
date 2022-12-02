package com.devs4j.callback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CallBacksApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CallBacksApplication.class, args);
		SpringApplication.exit(context);
	}

}
