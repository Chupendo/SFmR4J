package com.devs4j.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWordController {

	public ResponseEntity<String> helloWorld(){
		return new ResponseEntity<String>("Hello World!",HttpStatus.OK);
	}
}
