package com.devs4j.caching.configurations;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;


import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableCaching
public class CacheBeanConfig {


	//Cache admin local

	/*
	@Bean
	public CacheManager getManager() {
		return new ConcurrentMapCacheManager("user","roles","address");
	}*/

	// Caching admin with Redis
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
		Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
		redisCacheConfigurationMap.put("users", createConfing(3600, ChronoUnit.MINUTES));

		return RedisCacheManager
				.builder(redisConnectionFactory)
				.withInitialCacheConfigurations(redisCacheConfigurationMap)
				.build();
	}

	public static RedisCacheConfiguration createConfing(long time, ChronoUnit temporalUnit){
		return RedisCacheConfiguration.defaultCacheConfig()
				.disableCachingNullValues()
				.entryTtl(Duration.of(time,temporalUnit))
				.serializeValuesWith(RedisSerializationContext
						.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));

	}
}
