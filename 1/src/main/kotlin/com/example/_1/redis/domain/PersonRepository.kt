package com.example._1.redis.domain

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : CrudRepository<Person, Long>