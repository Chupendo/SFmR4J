package com.devs4j.swaggerapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API DEVS4J"))
public class SwaggerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApiApplication.class, args);
    }

}
