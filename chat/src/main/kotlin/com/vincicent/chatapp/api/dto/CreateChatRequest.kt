package com.vincicent.chatapp.api.dto

import com.vincicent.chatapp.domain.type.UserId
import jakarta.validation.constraints.Size

data class CreateChatRequest(
    @field:Size(
        min = 1,
        message = "Chats must have at least 2 unique participants"
    )
    val otherUserIds: List<UserId>
)