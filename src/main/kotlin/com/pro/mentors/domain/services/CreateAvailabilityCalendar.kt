package com.pro.mentors.domain.services

import com.pro.mentors.domain.entities.Event
import com.pro.mentors.domain.entities.EventType.FREE
import com.pro.mentors.rest.dto.requests.AvailabilityCalendarRequest
import com.pro.mentors.rest.dto.requests.ExceptionTime
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

        val exceptTime = datesConfig.exceptTimes

        var dateBetween: LocalDateTime = datesConfig.start
        while (!dateBetween.isAfter(datesConfig.end)) {
            when {
                isExceptDay(dateBetween, datesConfig.exceptDays) -> Unit
                isExceptTime(exceptTime, dateBetween.convertToLocalTime()) -> Unit
                else -> dates.add(dateBetween.format(formatter))
            }
            dateBetween = dateBetween.validateLimitTimeOnRage(datesConfig)
        }

        return dates.toList()
    }

    private fun LocalDateTime.validateLimitTimeOnRage(range: AvailabilityCalendarRequest): LocalDateTime {
        this.toLocalTime().let {
            it >= (range.start.toLocalTime()) &&
                it < (range.end.toLocalTime())}.takeIf { it }
            ?.let {
                return this.plus(Duration.of(1, unitHours))
            }

        return this.plusDays(1).withHour(range.start.hour)
    }

    private fun isExceptDay(localDateTime: LocalDateTime, daysOfWeek: List<DayOfWeek>): Boolean {
        return localDateTime.dayOfWeek in daysOfWeek
    }

    private fun isExceptTime(rangeList: List<ExceptionTime>, targetTime: LocalTime): Boolean {
        rangeList.forEach { range ->
            targetTime.isAfter(
                range.start.minus(
                    Duration.of(1, unitMinutes)
                )
            )
                .and(targetTime.isBefore(range.end))
                .takeIf { it }
                ?.let { return true }
        }
        return false
    }

    private fun String.toLocalDateTime() = LocalDateTime.parse(this, formatter)
    private fun LocalDateTime.convertToLocalTime() = LocalTime.parse(this.format(timeFormatter))
}