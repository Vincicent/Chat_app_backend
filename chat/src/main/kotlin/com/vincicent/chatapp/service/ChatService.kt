package com.vincicent.chatapp.service

import com.vincicent.chatapp.domain.exception.ChatParticipantNotFoundException
import com.vincicent.chatapp.domain.exception.InvalidChatSizeException
import com.vincicent.chatapp.domain.models.Chat
import com.vincicent.chatapp.domain.type.UserId
import com.vincicent.chatapp.infra.database.entities.ChatEntity
import com.vincicent.chatapp.infra.database.mappers.toChat
import com.vincicent.chatapp.infra.database.repositories.ChatParticipantRepository
import com.vincicent.chatapp.infra.database.repositories.ChatRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ChatService(
    private val chatRepository: ChatRepository,
    private val chatParticipantRepository: ChatParticipantRepository,
) {

    @Transactional
    fun createChat(
        creatorId: UserId,
        otherUserIds: Set<UserId>
    ): Chat {
        val otherParticipants = chatParticipantRepository.findByUserIdIn(
            userIds = otherUserIds.toList()
        )

        val allParticipants = (otherParticipants + creatorId)
        if(allParticipants.size < 2) {
            throw InvalidChatSizeException()
        }

        val creator = chatParticipantRepository.findByIdOrNull(creatorId)
            ?: throw ChatParticipantNotFoundException(creatorId)

        return chatRepository.save(
            ChatEntity(
                creator = creator,
                participants = setOf(creator) + otherParticipants
            )
        ).toChat(lastMessage = null)
    }
}