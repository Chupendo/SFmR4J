package com.devs4j.profiles.conf;

import org.springframework.stereotype.Component;

@Component
public class EnviromentImpl implements IEnviroment {

	@Override
	public String getEnviroment() {
		return "Enviroment {} : ";
	}

}
