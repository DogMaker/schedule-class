package com.pro.mentors.domain.services

import com.pro.mentors.domain.entities.Event
import com.pro.mentors.domain.entities.EventType.FREE
import com.pro.mentors.rest.dto.requests.AvailabilityCalendarRequest
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.UUID

class CreateAvailabilityCalendar {
    private val unit = ChronoUnit.valueOf("HOURS")
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")

    fun create(datesConfig: AvailabilityCalendarRequest): MutableList<Event> {

        val dates = generateRageDate(datesConfig.start, datesConfig.end)

        val events = mutableListOf<Event>()
        dates.forEach { date ->
            events.add(
                Event(
                    id = UUID.randomUUID(),
                    title = FREE.status,
                    eventType = FREE,
                    url = "",
                    date,
                    LocalDateTime.parse(date, formatter).plus(Duration.of(1, unit)).toString()
                )
            )
        }

        return events
    }

    fun generateRageDate(beginDate: LocalDateTime, endDate: LocalDateTime): List<String> {
        val dates = mutableListOf<String>()

        var dateBetween: LocalDateTime = beginDate
        while (!dateBetween.isAfter(endDate)) {
            dates.add(dateBetween.format(formatter))
            dateBetween = dateBetween.plus(Duration.of(1, unit))
        }

        return dates.toList()
    }
}

