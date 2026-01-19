package com.vincicent.chatapp.infra.security

import com.vincicent.chatapp.domain.exception.EncodePasswordException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordEncoder {
    private val bcrypt = BCryptPasswordEncoder()

    fun encode(rawPassword: String): String = bcrypt.encode(rawPassword) ?: throw EncodePasswordException()

    fun matches(rawPassword: String, hashedPassword: String): Boolean = bcrypt.matches(rawPassword, hashedPassword)
}