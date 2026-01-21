package com.vincicent.chatapp.events.user

import com.vincicent.chatapp.events.ChatappEvent
import com.vincicent.chatapp.domain.type.UserId
import java.time.Instant
import java.util.UUID

sealed class UserEvent(
    override val eventId: String = UUID.randomUUID().toString(),
    override val exchange: String = UserEventConstants.USER_EXCHANGE,
    override val occurredAt: Instant = Instant.now(),
): ChatappEvent {

    data class Created(
        val userId: UserId,
        val email: String,
        val username: String,
        val verificationToken: String,
        override val eventKey: String = UserEventConstants.USER_CREATED_KEY
    ): UserEvent(), ChatappEvent

    data class Verified(
        val userId: UserId,
        val email: String,
        val username: String,
        override val eventKey: String = UserEventConstants.USER_VERIFIED
    ): UserEvent(), ChatappEvent

    data class RequestResendVerification(
        val userId: UserId,
        val email: String,
        val username: String,
        val verificationToken: String,
        override val eventKey: String = UserEventConstants.USER_REQUEST_RESEND_VERIFICATION
    ): UserEvent(), ChatappEvent

    data class RequestResetPassword(
        val userId: UserId,
        val email: String,
        val username: String,
        val passwordResetToken: String,
        val expiresInMinutes: Long,
        override val eventKey: String = UserEventConstants.USER_REQUEST_RESET_PASSWORD
    ): UserEvent(), ChatappEvent
}