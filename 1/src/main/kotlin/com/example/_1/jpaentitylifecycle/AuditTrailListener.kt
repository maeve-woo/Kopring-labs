package com.example._1.jpaentitylifecycle

import com.example._1.jpaentitylifecycle.domain.User
import mu.KotlinLogging
import javax.persistence.*

private val log = KotlinLogging.logger {}

class AuditTrailListener {
	@PrePersist
	@PreUpdate
	@PreRemove
	fun beforeAnyUpdate(user: User) {
		if (user.id == null) {
			log.info { " >>> [User Audit] about to add a user" }
		} else {
			log.info { " >>> [User Audit] about to update/delete a user : ${user.id}" }
		}
	}

	@PostPersist
	@PostUpdate
	@PostRemove
	fun afterAnyUpdate(user: User) {
		log.info { " >>> [User Audit] add/update/delete complete for user: ${user.id}" }
	}
	
	@PostLoad
	fun after(user: User) {
		log.info { " >>> [User Audit] user loaded from database : ${user.id}" }
	}
}