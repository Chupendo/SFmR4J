package com.devs4j.profiles.conf;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("pro")
public class ProEnviroment implements IEnviroment {

	public String getEnviroment() {
		return "Pro";
	}
}
