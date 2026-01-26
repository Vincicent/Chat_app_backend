package com.vincicent.chatapp.api.dto.ws

import com.vincicent.chatapp.domain.type.ChatId
import com.vincicent.chatapp.domain.type.ChatMessageId

data class SendMessageDto(
    val chatId: ChatId,
    val content: String,
    val messageId: ChatMessageId? = null
)