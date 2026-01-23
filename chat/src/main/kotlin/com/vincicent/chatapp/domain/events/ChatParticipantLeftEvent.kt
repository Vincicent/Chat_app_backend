package com.vincicent.chatapp.domain.events

import com.vincicent.chatapp.domain.type.ChatId
import com.vincicent.chatapp.domain.type.UserId

data class ChatParticipantLeftEvent(
    val chatId: ChatId,
    val userId: UserId
)