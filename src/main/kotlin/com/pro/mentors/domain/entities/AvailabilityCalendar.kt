package com.pro.mentors.domain.entities

import java.time.DayOfWeek
import java.time.LocalDateTime

data class AvailabilityCalendar (
    val id: Int,
    val title: String,
    val eventType: EventType = EventType.FREE,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val exceptDays: List<DayOfWeek>,
    val exceptTimes: List<LocalDateTime>
)