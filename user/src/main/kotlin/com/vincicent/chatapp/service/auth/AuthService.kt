package com.vincicent.chatapp.service.auth

import com.vincicent.chatapp.domain.exception.UserAlreadyExistsException
import com.vincicent.chatapp.domain.model.User
import com.vincicent.chatapp.infra.database.entities.UserEntity
import com.vincicent.chatapp.infra.database.mappers.toUser
import com.vincicent.chatapp.infra.database.repositories.UserRepository
import com.vincicent.chatapp.infra.security.PasswordEncoder
import org.springframework.stereotype.Service

@Service

class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(email: String, username: String, password: String): User {
        val user = userRepository.findByEmailOrUsername(
            email = email.trim(),
            username = username.trim()
        )

        if (user != null) {
            throw UserAlreadyExistsException()
        }

        val savedUser = userRepository.save(
            UserEntity(
                email = email.trim(),
                username = username.trim(),
                hashedPassword = passwordEncoder.encode(password)
            )
        ).toUser()

        return savedUser
    }
}