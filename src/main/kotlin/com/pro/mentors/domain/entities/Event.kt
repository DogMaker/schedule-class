package com.pro.mentors.domain.entities

import java.util.*

data class Event(
    val id: UUID,
    val title: String,
    val eventType: EventType,
    val url: String,
    val start: String,
    val end: String
)
