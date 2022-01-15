package com.pro.mentors.rest.dto.requests

import com.pro.mentors.domain.entities.EventType
import java.time.DayOfWeek
import java.time.LocalDateTime

data class AvailabilityCalendarRequest (
    val eventType: EventType = EventType.FREE,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val exceptDays: List<DayOfWeek>,
    val exceptTimes: List<LocalDateTime>
)