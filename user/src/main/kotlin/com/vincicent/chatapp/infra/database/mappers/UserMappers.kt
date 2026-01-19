package com.vincicent.chatapp.infra.database.mappers

import com.vincicent.chatapp.domain.model.User
import com.vincicent.chatapp.infra.database.entities.UserEntity

fun UserEntity.toUser(): User {
    return User(
        id = id!!,
        username = username,
        email = email,
        hasEmailVerified = hasVerifiedEmail
    )
}