package com.vincicent.chatapp.infra.database.mappers

import com.vincicent.chatapp.domain.model.EmailVerificationToken
import com.vincicent.chatapp.infra.database.entities.EmailVerificationTokenEntity

fun EmailVerificationTokenEntity.toEmailVerificationToken(): EmailVerificationToken {
    return EmailVerificationToken(
        id = id,
        token = token,
        user = user.toUser()
    )
}