package com.example._1.jpaentitylifecycle

import com.example._1.jpaentitylifecycle.domain.User
import com.example._1.jpaentitylifecycle.domain.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import javax.persistence.EntityManager

@DataJpaTest
internal class EntityLifecycleEventTest @Autowired constructor(
	val userRepository: UserRepository,
	val entityManager: EntityManager
) {
	@Test
	fun `ㄲㅑ`() {
		var user = User("maboo", "woo")

		user = userRepository.save(user)
		assertThat(entityManager.contains(user)).isTrue

		println("--- remove --- ")

		entityManager.remove(user)
		entityManager.flush()
		assertThat(entityManager.contains(user)).isFalse

		println("--- merge --- ")

		user = entityManager.merge(user) // OK : https://umanking.github.io/2019/04/12/jpa-persist-merge/

		entityManager.flush()
		assertThat(entityManager.contains(user)).isTrue

		println("--- remove --- ")

		entityManager.remove(user)
		assertThat(entityManager.contains(user)).isFalse

		println("--- persist --- ")

		entityManager.persist(user)
		assertThat(entityManager.contains(user)).isTrue

	}

}