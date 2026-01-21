package com.vincicent.chatapp.events

import java.time.Instant

interface ChatappEvent {
    val eventId: String
    val eventKey: String
    val occurredAt: Instant
    val exchange: String
}