package com.devs4j.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.devs4j.di.inyection.Coche;
import com.devs4j.di.qualfiers.Animal;
import com.devs4j.di.qualfiers.Avion;
import com.devs4j.di.qualfiers.Nido;
import com.devs4j.di.qualfiers.Pajaro;
import com.devs4j.di.qualfiers.Perro;

@SpringBootApplication
public class DependencyInjectionApplication {

	private static final Logger log = LoggerFactory.getLogger(DependencyInjectionApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);

		Coche coche = context.getBean(Coche.class);
		log.info(coche.toString());

		Perro perro = context.getBean(Perro.class);
		log.info(perro.toString());

		Pajaro pajaro = context.getBean(Pajaro.class);
		log.info(pajaro.toString());
		pajaro.volar();

		Avion avion = context.getBean(Avion.class);
		log.info(avion.toString());
		avion.volar();

		// Sobrecarga del método "getBean(nombre_qualifier,class);
		Animal animal = context.getBean("perro", Animal.class);
		log.info(animal.toString());

		//Animal tiene dos implementaciones: Peror y Pajaro
		//esto tiene un error a la hora de resolver las 
		//dependencias, ya que no sabe que cual elegir.
		//Para resolverlo se usa "Qualifiers" o en su
		//defecto la sobrecarga del método "getBean()"
		//y pasarle al contexto, el nombre del qualifiers y
		//el tipo de dato que se quiere implementar
		//"getBean(nombre_qualifier,tipo_dato);
		Animal animal2 = context.getBean("pajarito", Animal.class);
		log.info(animal2.toString());
		
		
		//Uso de Qualifiers dentro de una clase
		Nido nido = context.getBean(Nido.class);
		nido.msg();
	}

}
