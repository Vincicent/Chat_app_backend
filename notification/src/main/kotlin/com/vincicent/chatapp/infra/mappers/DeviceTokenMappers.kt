package com.vincicent.chatapp.infra.mappers

import com.vincicent.chatapp.domain.model.DeviceToken
import com.vincicent.chatapp.infra.database.entities.DeviceTokenEntity

fun DeviceTokenEntity.toDeviceToken(): DeviceToken {
    return DeviceToken(
        userId = userId,
        token = token,
        platform = platform.toPlatform(),
        createdAt = createdAt,
        id = id
    )
}