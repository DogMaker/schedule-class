package com.pro.mentors.domain.entities

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

data class AvailabilityCalendar (
    val id: Int,
    val title: String,
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