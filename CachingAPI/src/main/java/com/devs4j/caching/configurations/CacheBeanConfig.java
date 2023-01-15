package com.devs4j.caching.configurations;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class CacheBeanConfig {

	/*
	//Cache admin local

	@Bean
	public CacheManager getManager() {
		return new ConcurrentMapCacheManager("user","roles","address");
	}

	*/
	//Cache admin redis
	@Bean
	public CacheManager  getManager(RedissonClient redissonClient){
		Map<String, CacheConfig> config = new HashMap<>();
		config.put("users",new CacheConfig(24*60*1000, 12*60*1000));
		return (CacheManager) new RedissonSpringCacheManager(redissonClient,config);
	}
	@Bean(destroyMethod = "shutdown")
	public RedissonClient redisson(){
		Config config = new Config();
		config.useSingleServer()
				//.setAddress("redis://127.0.0.1:6379");
				.setAddress("redis://172.28.224.1:6379");
				//.setAddress("redis://192.168.56.1:6379");

		return Redisson.create(config);
	}


}
