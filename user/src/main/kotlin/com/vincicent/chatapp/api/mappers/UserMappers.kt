package com.vincicent.chatapp.api.mappers

import com.vincicent.chatapp.api.dto.AuthenticatedUserDto
import com.vincicent.chatapp.api.dto.UserDto
import com.vincicent.chatapp.domain.model.AuthenticatedUser
import com.vincicent.chatapp.domain.model.User

fun AuthenticatedUser.toAuthenticatedUserDto(): AuthenticatedUserDto {
    return AuthenticatedUserDto(
        user = user.toUserDto(),
        accessToken = accessToken,
        refreshToken = refreshToken
    )
}

fun User.toUserDto(): UserDto {
    return UserDto(
        id = id,
        email = email,
        username = username,
        hasVerifiedEmail = hasEmailVerified
    )
}