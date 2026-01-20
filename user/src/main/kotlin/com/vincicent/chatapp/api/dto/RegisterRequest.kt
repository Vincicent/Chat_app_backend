package com.vincicent.chatapp.api.dto

import com.vincicent.chatapp.api.util.Password
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length

data class RegisterRequest(
    @field:Email
    val email: String,
    @field:Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    val username: String,
    @field:Password
    val password: String
)