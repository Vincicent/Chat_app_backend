package com.vincicent.chatapp.api.dto

import com.vincicent.chatapp.domain.type.UserId
import jakarta.validation.constraints.Size

data class AddParticipantToChatDto(
    @field:Size(min = 1)
    val userIds: List<UserId>
)