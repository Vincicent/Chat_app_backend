package com.vincicent.chatapp.infra.database.repositories

import com.vincicent.chatapp.domain.model.UserId
import com.vincicent.chatapp.infra.database.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, UserId> {
    fun findByEmail(email: String): UserEntity?
    fun findByEmailOrUsername(email: String, username: String): UserEntity?
}