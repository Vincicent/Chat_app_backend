package com.vincicent.chatapp.domain.models

import com.vincicent.chatapp.domain.type.UserId

data class ChatParticipant(
    val userId: UserId,
    val username: String,
    val email: String,
    val profilePictureUrl: String?
)