package com.devs4j.profiles.conf;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("qa")
public class QaEnviroment implements IEnviroment {

	
	public String getEnviroment() {
		return "Qa";
	}
}
