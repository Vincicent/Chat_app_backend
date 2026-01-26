package com.vincicent.chatapp.api.dto.ws

import com.vincicent.chatapp.domain.type.ChatId
import com.vincicent.chatapp.domain.type.ChatMessageId

data class DeleteMessageDto(
    val chatId: ChatId,
    val messageId: ChatMessageId
)