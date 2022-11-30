package com.devs4j.profiles.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("qa")
public class QaEnviroment {

	@Autowired
	IEnviroment enviroment;
	
	public String getEnviroment() {
		return enviroment.getEnviroment()+"Qa";
	}
}
