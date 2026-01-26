package com.vincicent.chatapp.api.dto.ws

import com.vincicent.chatapp.domain.type.UserId

data class ProfilePictureUpdateDto(
    val userId: UserId,
    val newUrl: String?
)