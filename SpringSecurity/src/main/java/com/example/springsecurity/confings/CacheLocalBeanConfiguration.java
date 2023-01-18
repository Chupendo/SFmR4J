package com.example.springsecurity.confings;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheLocalBeanConfiguration {

	@Bean
	public CacheManager getManager() {
		return new ConcurrentMapCacheManager("users","roles","address");
	}
}