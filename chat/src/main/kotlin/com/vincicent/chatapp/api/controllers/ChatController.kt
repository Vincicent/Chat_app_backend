package com.vincicent.chatapp.api.controllers

import com.vincicent.chatapp.api.dto.ChatDto
import com.vincicent.chatapp.api.dto.CreateChatRequest
import com.vincicent.chatapp.api.mappers.toChatDto
import com.vincicent.chatapp.api.util.requestUserId
import com.vincicent.chatapp.service.ChatService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/chat")
class ChatController(
    private val chatService: ChatService
) {

    @PostMapping
    fun createChat(
        @Valid @RequestBody body: CreateChatRequest
    ): ChatDto {
        return chatService.createChat(
            creatorId = requestUserId,
            otherUserIds = body.otherUserIds.toSet()
        ).toChatDto()
    }
}