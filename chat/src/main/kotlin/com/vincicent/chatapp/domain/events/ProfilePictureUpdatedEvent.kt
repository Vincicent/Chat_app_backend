package com.vincicent.chatapp.domain.events

import com.vincicent.chatapp.domain.type.UserId

data class ProfilePictureUpdatedEvent(
    val userId: UserId,
    val newUrl: String?
)