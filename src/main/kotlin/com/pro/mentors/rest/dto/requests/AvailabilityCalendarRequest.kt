package com.pro.mentors.rest.dto.requests

import com.pro.mentors.domain.entities.EventType
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

data class AvailabilityCalendarRequest (
    val eventType: EventType = EventType.FREE,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val exceptDays: List<DayOfWeek>,
    val exceptTimes: List<ExceptionTime>
)

data class ExceptionTime(
    val start: LocalTime,
    val end: LocalTime
)