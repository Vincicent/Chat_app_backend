package com.vincicent.chatapp.api.exception_handling

import com.vincicent.chatapp.domain.exception.ChatNotFoundException
import com.vincicent.chatapp.domain.exception.ChatParticipantNotFoundException
import com.vincicent.chatapp.domain.exception.InvalidChatSizeException
import com.vincicent.chatapp.domain.exception.MessageNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(
        MessageNotFoundException::class,
        ChatParticipantNotFoundException::class,
        ChatNotFoundException::class
    )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun onNotFoundException(
        e: Exception
    ) = mapOf(
        "code" to "NOT_FOUND",
        "message" to e.message
    )

    @ExceptionHandler(InvalidChatSizeException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun onInvalidChatSizeException(
        e: InvalidChatSizeException
    ) = mapOf(
        "code" to "INVALID_CHAT_SIZE",
        "message" to e.message
    )
}