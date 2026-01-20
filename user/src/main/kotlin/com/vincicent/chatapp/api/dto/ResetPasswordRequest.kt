package com.vincicent.chatapp.api.dto

import com.vincicent.chatapp.api.util.Password
import jakarta.validation.constraints.NotBlank

data class ResetPasswordRequest(
    @field:NotBlank
    val token: String,
    @field:Password
    val newPassword: String
)