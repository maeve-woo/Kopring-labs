package com.example._1.jpaentitylifecycle.domain

import com.example._1.jpaentitylifecycle.AuditTrailListener
import mu.KotlinLogging
import javax.persistence.*
import kotlin.jvm.Transient

private val log = KotlinLogging.logger {}

@EntityListeners(AuditTrailListener::class)
@Entity
class User(
	var firstName: String,

	var lastName: String,

	@Transient
	var fullName: String? = null,

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long? = null
) {
	@PrePersist
	fun logNewUserAttempt() {
		log.info { " >>> Attempting to add new user with username: $firstName" }
	}

	@PostPersist
	fun logNewUserAdded() {
		log.info { " >>> Added user $firstName with ID: $id" }
	}

	@PreRemove
	fun logUserRemovalAttempt() {
		log.info { " >>> Attempting to delete user: $firstName" }
	}

	@PostRemove
	fun logUserRemoval() {
		log.info { " >>> Deleted user: $firstName" }
	}

	@PreUpdate
	fun logUserUpdateAttempt() {
		log.info { " >>> Attempting to update user: $firstName" }
	}

	@PostUpdate
	fun logUserUpdate() {
		log.info { " >>> Updated user: $firstName" }
	}

	@PostLoad
	fun logUserLoad() {
		fullName = "$firstName $lastName";
	}
}