package com.vincicent.chatapp.service

import com.vincicent.chatapp.api.dto.ChatMessageDto
import com.vincicent.chatapp.api.mappers.toChatMessageDto
import com.vincicent.chatapp.domain.exception.ChatNotFoundException
import com.vincicent.chatapp.domain.exception.ChatParticipantNotFoundException
import com.vincicent.chatapp.domain.exception.ForbiddenException
import com.vincicent.chatapp.domain.exception.MessageNotFoundException
import com.vincicent.chatapp.domain.models.ChatMessage
import com.vincicent.chatapp.domain.type.ChatId
import com.vincicent.chatapp.domain.type.ChatMessageId
import com.vincicent.chatapp.domain.type.UserId
import com.vincicent.chatapp.infra.database.entities.ChatMessageEntity
import com.vincicent.chatapp.infra.database.mappers.toChatMessage
import com.vincicent.chatapp.infra.database.repositories.ChatMessageRepository
import com.vincicent.chatapp.infra.database.repositories.ChatParticipantRepository
import com.vincicent.chatapp.infra.database.repositories.ChatRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant

@Service
class ChatMessageService(
    private val chatRepository: ChatRepository,
    private val chatMessageRepository: ChatMessageRepository,
    private val chatParticipantRepository: ChatParticipantRepository
) {
    @Transactional
    fun sendMessage(
        chatId: ChatId,
        senderId: UserId,
        content: String,
        messageId: ChatMessageId? = null
    ): ChatMessage {
        val chat = chatRepository.findChatById(chatId, senderId)
            ?: throw ChatNotFoundException()
        val sender = chatParticipantRepository.findByIdOrNull(senderId)
            ?: throw ChatParticipantNotFoundException(senderId)

        val savedMessage = chatMessageRepository.save(
            ChatMessageEntity(
                id = messageId,
                content = content.trim(),
                chatId = chatId,
                chat = chat,
                sender = sender
            )
        )

        return savedMessage.toChatMessage()
    }

    @Transactional
    fun deleteMessage(
        messageId: ChatMessageId,
        requestUserId: UserId
    ) {
        val message = chatMessageRepository.findByIdOrNull(messageId)
            ?: throw MessageNotFoundException(messageId)

        if(message.sender.userId != requestUserId) {
            throw ForbiddenException()
        }

        chatMessageRepository.delete(message)
    }
}