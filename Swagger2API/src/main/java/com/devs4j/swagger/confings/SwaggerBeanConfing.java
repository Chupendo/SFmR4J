package com.devs4j.swagger.confings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerBeanConfing {
	//uri: http://localhost:8081/v2/api-docs
	//uri: http://localhost:8081/swagger-ui.html
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				//.apis(RequestHandlerSelectors.basePackage("com.devs4j.swagger.controller"))
		        .paths(PathSelectors.any())
		        //.paths(PathSelectors.ant("/hello/*"))
		        .build();
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Swagger 2 Hello Rest")
				.description("API Hello")
				.termsOfServiceUrl("http://localhots:8080/hello")
				.contact(getContact())
				.licenseUrl("free").version("1.0").build();
	}
	
	private Contact getContact() {
		
		return new Contact("Andres", "url not found", "arp@gmailc.om");
	}
}
