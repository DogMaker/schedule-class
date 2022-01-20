package com.pro.mentors.domain.entities

import java.time.LocalDateTime

data class Schedule(
    val eventId: Int,
    val eventBlock: EventType,
    val start: LocalDateTime,
    val end: LocalDateTime
)
