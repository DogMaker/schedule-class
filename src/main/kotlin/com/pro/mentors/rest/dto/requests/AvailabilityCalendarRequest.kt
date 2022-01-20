package com.pro.mentors.rest.dto.requests

import com.pro.mentors.domain.entities.AvailabilityCalendar
import com.pro.mentors.domain.entities.EventType
import com.pro.mentors.domain.entities.ExceptionTime
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

data class AvailabilityCalendarRequest (
    val eventType: EventType = EventType.FREE,
    val start: LocalDateTime,
    val end: LocalDateTime,
    val exceptDays: List<DayOfWeek>,
    val exceptTimes: List<ExceptionTimeRequest>
)

data class ExceptionTimeRequest(
    val start: LocalTime,
    val end: LocalTime
)

fun AvailabilityCalendarRequest.toAvailabilityCalendar()= AvailabilityCalendar(
    eventType = this.eventType,
    start = this.start,
    end = this.end,
    exceptDays = this.exceptDays,
    exceptTimes = this.exceptTimes.toExceptTimes(),
    id = "PlaceHolder",
    title = "Free"
)

fun List<ExceptionTimeRequest>.toExceptTimes(): List<ExceptionTime> {
    val exceptTimesList = mutableListOf<ExceptionTime>()
    this.forEach {
        times ->
        exceptTimesList.add(ExceptionTime( times.start, times.end))
    }
    return exceptTimesList.toList()
}