package com.vincicent.chatapp.domain.exception

import com.vincicent.chatapp.domain.type.ChatMessageId

class MessageNotFoundException(
    private val id: ChatMessageId
): RuntimeException(
    "Message with ID $id not found"
)