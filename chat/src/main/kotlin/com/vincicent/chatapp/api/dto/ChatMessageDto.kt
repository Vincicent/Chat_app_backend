package com.vincicent.chatapp.api.dto

import com.vincicent.chatapp.domain.type.ChatId
import com.vincicent.chatapp.domain.type.ChatMessageId
import com.vincicent.chatapp.domain.type.UserId
import java.time.Instant

data class ChatMessageDto(
    val id: ChatMessageId,
    val chatId: ChatId,
    val content: String,
    val createdAt: Instant,
    val senderId: UserId
)