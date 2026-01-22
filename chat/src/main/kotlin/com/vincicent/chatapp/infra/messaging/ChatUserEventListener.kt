package com.vincicent.chatapp.infra.messaging

import com.vincicent.chatapp.domain.models.ChatParticipant
import com.vincicent.chatapp.events.user.UserEvent
import com.vincicent.chatapp.infra.message_queue.MessageQueues
import com.vincicent.chatapp.service.ChatParticipantService
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ChatUserEventListener(
    private val chatParticipantService: ChatParticipantService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @RabbitListener(queues = [MessageQueues.CHAT_USER_EVENTS])
    fun handleUserEvent(event: UserEvent) {
        logger.info("Received user event: {}", event)
        when(event) {
            is UserEvent.Verified -> {
                chatParticipantService.createChatParticipant(
                    chatParticipant = ChatParticipant(
                        userId = event.userId,
                        username = event.username,
                        email = event.email,
                        profilePictureUrl = null
                    )
                )
            }
            else -> Unit
        }
    }
}