package com.example._1.redis.config

import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@Configuration
@EnableRedisRepositories
@EnableCaching
class Redis {
	@Bean
	fun redisConnectionFactory(): LettuceConnectionFactory {
		return LettuceConnectionFactory("localhost", 6379)
	}

	@Bean
	fun redisTemplate(): RedisTemplate<*, *> {
		val redisTemplate = RedisTemplate<String, Any>()
		redisTemplate.setConnectionFactory(redisConnectionFactory())
		return redisTemplate
	}
}