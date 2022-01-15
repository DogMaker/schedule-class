package com.pro.mentors.domain.services

import com.pro.mentors.domain.entities.Event
import com.pro.mentors.domain.entities.EventType.FREE
import com.pro.mentors.rest.dto.requests.AvailabilityCalendarRequest
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class CreateAvailabilityCalendar {
    private val unitHours = ChronoUnit.valueOf("HOURS")
    private val unitMinutes = ChronoUnit.valueOf("MINUTES")
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")


    fun create(datesConfig: AvailabilityCalendarRequest): MutableList<Event> {

        val dates = generateRageDate(datesConfig)

        val events = mutableListOf<Event>()
        dates.forEach { date ->
            events.add(
                Event(
                    eventType = FREE,
                    start = date,
                    end = date.toLocalDateTime().plus(Duration.of(1, unitHours)).toString()
                )
            )
        }

        return events
    }

    private fun generateRageDate(datesConfig: AvailabilityCalendarRequest): List<String> {
        val dates = mutableListOf<String>()
        val oneHour = 1L

        val getFirstSetTime = datesConfig.exceptTimes.first()

        var dateBetween: LocalDateTime = datesConfig.start
        while (!dateBetween.isAfter(datesConfig.end)) {
            when {
                isExceptDay(dateBetween, datesConfig.exceptDays) ->  Unit
                isExceptTime(getFirstSetTime,LocalTime.parse(dateBetween.format(timeFormatter))) ->  Unit
                else ->  dates.add(dateBetween.format(formatter))
            }
            dateBetween = dateBetween.plus(Duration.of(oneHour, unitHours))
        }

        return dates.toList()
    }

    private fun isExceptDay(localDateTime: LocalDateTime, daysOfWeek: List<DayOfWeek>): Boolean {
        return localDateTime.dayOfWeek in daysOfWeek
    }

    private fun isExceptTime(range: com.pro.mentors.rest.dto.requests.ExceptionTime, targetTime: LocalTime): Boolean {
        return targetTime.isAfter(range.start.minus(Duration.of(1, unitMinutes)))
                .and(targetTime.isBefore(range.end))
    }

    private fun String.toLocalDateTime() = LocalDateTime.parse(this, formatter)

}