package com.vincicent.chatapp.api.dto

import com.vincicent.chatapp.domain.model.UserId

data class UserDto(
    val id: UserId,
    val email: String,
    val username: String,
    val hasVerifiedEmail: Boolean,
)
