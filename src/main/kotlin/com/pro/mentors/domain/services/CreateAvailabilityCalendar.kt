package com.pro.mentors.domain.services

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class CreateAvailabilityCalendar {

    fun create(beginDate: LocalDateTime, endDate: LocalDateTime ): List<String> {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")

        val unit = ChronoUnit.valueOf("HOURS")
        val  dates =  mutableListOf<String>()

        var dateBetween: LocalDateTime = beginDate
        while (!dateBetween.isAfter(endDate)) {
            dates.add(dateBetween.format(formatter))
            dateBetween = dateBetween.plus(Duration.of(1,unit))
        }

        return dates.toList()
    }
}


