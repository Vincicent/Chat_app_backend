package com.vincicent.chatapp.domain.exception

import com.vincicent.chatapp.domain.type.UserId

class ChatParticipantNotFoundException(
    private val id: UserId
): RuntimeException(
    "The chat participant with the ID $id was not found."
)