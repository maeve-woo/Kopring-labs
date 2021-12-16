package com.example._1.redis.domain

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

@RedisHash(value = "product", timeToLive = 30)
// value : Redis의 Keyspace, timeToLive : 만료시간을 Seconds 단위로 설정할 수 있다. 기본값은 만료시간이 없는 -1L
class Person(
	var name: String,
	var age: Int
) {
	fun updateName(name: String) {
		this.name = name
	}

	fun updateAge(age: Int) {
		this.age = age
	}

	@Id
	var id: Long? = null
}