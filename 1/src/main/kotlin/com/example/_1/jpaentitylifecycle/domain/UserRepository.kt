package com.example._1.jpaentitylifecycle.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
	fun findByFirstName(firstName: String)
}