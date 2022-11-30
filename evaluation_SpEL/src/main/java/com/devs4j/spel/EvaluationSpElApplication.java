package com.devs4j.spel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@SpringBootApplication
public class EvaluationSpElApplication {

	private static final Logger log = LoggerFactory.getLogger(EvaluationSpElApplication.class);

	public static void main(String[] args) {
		//Ejemplo de SpEL
		ExpressionParser parser  = new SpelExpressionParser();
		//Expression expression =  parser.parseExpression("10+20");
		//Expression expression =  parser.parseExpression("10 eq 20");
		Expression expression =  parser.parseExpression("10 le 20");
		
		log.info("String expreison {}"+expression.getValue());
		// Se crea el contexto de Spring
		SpringApplication.run(EvaluationSpElApplication.class, args);
	}

}
