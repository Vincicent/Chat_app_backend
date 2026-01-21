package com.vincicent.chatapp.domain.model

import com.vincicent.chatapp.domain.type.UserId

data class User(
    val id: UserId,
    val username: String,
    val email: String,
    val hasEmailVerified: Boolean
)