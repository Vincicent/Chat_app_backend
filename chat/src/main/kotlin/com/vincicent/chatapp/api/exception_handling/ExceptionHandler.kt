package com.vincicent.chatapp.api.exception_handling

import com.vincicent.chatapp.domain.exception.ChatParticipantNotFoundException
import com.vincicent.chatapp.domain.exception.InvalidChatSizeException
import com.vincicent.chatapp.domain.exception.UnauthorizedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(ChatParticipantNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun onChatParticipantNotFoundException(
        e: ChatParticipantNotFoundException
    ) = mapOf(
        "code" to "NOT_FOUND",
        "message" to e.message
    )

    @ExceptionHandler(InvalidChatSizeException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun onInvalidChatSizeException(
        e: InvalidChatSizeException
    ) = mapOf(
        "code" to "BAD_REQUEST",
        "message" to e.message
    )
}