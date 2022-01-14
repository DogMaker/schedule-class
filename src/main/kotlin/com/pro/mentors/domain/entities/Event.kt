package com.pro.mentors.domain.entities

import java.time.LocalDateTime

data class Event(
    val id: Int,
    val title: String,
    val eventType: EventType,
    val url: String,
    val start: LocalDateTime,
    val end: LocalDateTime
)
