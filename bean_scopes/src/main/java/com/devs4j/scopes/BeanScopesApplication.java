package com.devs4j.scopes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.scopes.conf.EjemploScopeService;
import com.devs4j.scopes.conf.EjemploScopeService2;

@SpringBootApplication
public class BeanScopesApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BeanScopesApplication.class);


	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(BeanScopesApplication.class, args);
		
		//Scope Singleton (por defecto), una unica instancia (un solo objeto) por componente
		EjemploScopeService ejemploScopeService = context.getBean(EjemploScopeService.class);
		EjemploScopeService ejemploScopeService1 = context.getBean(EjemploScopeService.class);
		
		//Con == compara referencias y con equal compara el hash del objeto
		log.info("Arm beans equal {} "+ejemploScopeService.equals(ejemploScopeService1));
		log.info("Arm beans == {} "+(ejemploScopeService == ejemploScopeService1));
		
		//Scope Prototype (por cada peticion "getBean() o Autowired" crea uno nuevo
		EjemploScopeService2 ejemploScopeService2 = context.getBean(EjemploScopeService2.class);
		EjemploScopeService2 ejemploScopeService3 = context.getBean(EjemploScopeService2.class);
		
		
		//Con == compara referencias y con equal compara el hash del objeto
		log.info("Arm beans equal {} "+ejemploScopeService2.equals(ejemploScopeService3));
		log.info("Arm beans == {} "+(ejemploScopeService2 == ejemploScopeService3));
	}

}
