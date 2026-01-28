package com.vincicent.chatapp.api.dto

import com.vincicent.chatapp.domain.type.UserId
import java.time.Instant

data class DeviceTokenDto(
    val userId: UserId,
    val token: String,
    val createdAt: Instant
)