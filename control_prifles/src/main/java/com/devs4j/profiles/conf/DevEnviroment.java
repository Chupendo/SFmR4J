package com.devs4j.profiles.conf;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev","default")
public class DevEnviroment implements IEnviroment {

	public String getEnviroment() {
		return "Dev";
	}
}
