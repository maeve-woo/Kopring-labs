package com.example._1.redis.domain

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface PersonService {
	fun getPerson(id: Long): Person

	fun updatePersonName(id: Long, name: String): Person

	fun updatePersonAge(id: Long, age: Int): Person

	fun createPerson(person: Person): Person

	fun deletePerson(id: Long)
}

@Service
@Transactional
class DefaultPersonService(
	val personRepository: PersonRepository
) : PersonService {
	override fun getPerson(id: Long): Person {
		return personRepository.findById(id)
			.orElseThrow { throw IllegalArgumentException() }
	}

	override fun updatePersonName(id: Long, name: String): Person {
		val person = personRepository.findById(id)
			.orElseThrow { throw IllegalArgumentException() }

		person.updateName(name)
		return person
	}

	override fun updatePersonAge(id: Long, age: Int): Person {
		val person = personRepository.findById(id)
			.orElseThrow { throw IllegalArgumentException() }

		person.updateAge(age)
		return person
	}

	override fun createPerson(person: Person): Person {
		return personRepository.save(Person("maeve", 20))
	}

	override fun deletePerson(id: Long){
		personRepository.deleteById(id)
	}
}