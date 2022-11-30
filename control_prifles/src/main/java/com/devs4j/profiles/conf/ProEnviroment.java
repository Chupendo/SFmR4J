package com.devs4j.profiles.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
public class ProEnviroment {

	@Autowired
	IEnviroment enviroment;
	
	public String getEnviroment() {
		return enviroment.getEnviroment()+"Pro";
	}
}
