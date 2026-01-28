package com.vincicent.chatapp.infra.database.repositories

import com.vincicent.chatapp.domain.type.UserId
import com.vincicent.chatapp.infra.database.entities.DeviceTokenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DeviceTokenRepository: JpaRepository<DeviceTokenEntity, Long> {
    fun findByUserIdIn(userIds: List<UserId>): List<DeviceTokenEntity>
    fun findByToken(token: String): DeviceTokenEntity?
    fun deleteByToken(token: String)
}