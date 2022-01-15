package com.pro.mentors.domain.services

import com.pro.mentors.domain.entities.Event
import com.pro.mentors.domain.entities.EventType.FREE
import com.pro.mentors.rest.dto.requests.AvailabilityCalendarRequest
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class CreateAvailabilityCalendar {
    private val unit = ChronoUnit.valueOf("HOURS")
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")

    fun create(datesConfig: AvailabilityCalendarRequest): MutableList<Event> {

        val dates = generateRageDate(datesConfig.start, datesConfig.end, datesConfig.exceptDays)

        val events = mutableListOf<Event>()
        dates.forEach { date ->
            events.add(
                Event(
                    eventType = FREE,
                    start = date,
                    end = date.toLocalDateTime().plus(Duration.of(1, unit)).toString()
                )
            )
        }

        return events
    }

    fun generateRageDate(beginDate: LocalDateTime, endDate: LocalDateTime, exceptDays: List<DayOfWeek>): List<String> {
        val dates = mutableListOf<String>()
        val oneHour = 1L

        var dateBetween: LocalDateTime = beginDate
        while (!dateBetween.isAfter(endDate)) {
            when(isExceptDay(dateBetween, exceptDays)){
                true ->  println("No allowed")
                else ->  dates.add(dateBetween.format(formatter))
            }
            dateBetween = dateBetween.plus(Duration.of(oneHour, unit))
        }

        return dates.toList()
    }

    private fun isExceptDay(localDateTime: LocalDateTime, daysOfWeek: List<DayOfWeek>): Boolean {
        return localDateTime.dayOfWeek in daysOfWeek
    }

    private fun String.toLocalDateTime() = LocalDateTime.parse(this, formatter)

}

