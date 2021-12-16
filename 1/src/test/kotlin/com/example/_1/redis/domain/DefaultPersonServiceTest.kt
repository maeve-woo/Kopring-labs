package com.example._1.redis.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
internal class DefaultPersonServiceTest @Autowired constructor(
	val personRepository: PersonRepository
) {

	@Test
	@Rollback(false)
	fun `Hello RedisRepository!`() {
		var person = Person("maeve", 20)

		person = personRepository.save(person)

		val savedPerson = personRepository.findById(person.id!!)

		assertThat(savedPerson.get().name).isEqualTo("maeve")
	}
}