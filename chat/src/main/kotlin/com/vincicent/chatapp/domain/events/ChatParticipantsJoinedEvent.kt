package com.vincicent.chatapp.domain.events

import com.vincicent.chatapp.domain.type.ChatId
import com.vincicent.chatapp.domain.type.UserId

data class ChatParticipantsJoinedEvent(
    val chatId: ChatId,
    val userIds: Set<UserId>
)