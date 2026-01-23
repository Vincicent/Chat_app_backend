package com.vincicent.chatapp.domain.events

import com.vincicent.chatapp.domain.type.ChatId
import com.vincicent.chatapp.domain.type.ChatMessageId

data class MessageDeletedEvent(
    val chatId: ChatId,
    val messageId: ChatMessageId,
)