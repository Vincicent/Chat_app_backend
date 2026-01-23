package com.vincicent.chatapp.events.chat

import com.vincicent.chatapp.domain.type.ChatId
import com.vincicent.chatapp.domain.type.UserId
import com.vincicent.chatapp.events.ChatappEvent
import java.time.Instant
import java.util.UUID

sealed class ChatEvent(
    override val eventId: String = UUID.randomUUID().toString(),
    override val exchange: String = ChatEventConstants.CHAT_EXCHANGE,
    override val occurredAt: Instant = Instant.now(),
): ChatappEvent {

    data class NewMessage(
        val senderId: UserId,
        val senderUsername: String,
        val recipientIds: Set<UserId>,
        val chatId: ChatId,
        val message: String,
        override val eventKey: String = ChatEventConstants.CHAT_NEW_MESSAGE
    ): ChatEvent(), ChatappEvent
}