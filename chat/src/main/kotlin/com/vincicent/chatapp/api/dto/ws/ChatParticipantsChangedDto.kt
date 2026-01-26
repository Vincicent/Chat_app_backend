package com.vincicent.chatapp.api.dto.ws

import com.vincicent.chatapp.domain.type.ChatId

data class ChatParticipantsChangedDto(
    val chatId: ChatId
)