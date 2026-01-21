package com.vincicent.chatapp.api.util

import com.vincicent.chatapp.domain.exception.UnauthorizedException
import com.vincicent.chatapp.domain.type.UserId
import org.springframework.security.core.context.SecurityContextHolder

val requestUserId: UserId
    get() = SecurityContextHolder.getContext().authentication?.principal as? UserId
        ?: throw UnauthorizedException()