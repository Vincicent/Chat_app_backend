package com.vincicent.chatapp.api.dto

import com.vincicent.chatapp.api.util.Password
import jakarta.validation.constraints.NotBlank

data class ChangePasswordRequest(
    @field:NotBlank
    val oldPassword: String,
    @field:Password
    val newPassword: String
)