package com.pro.mentors.domain

import com.pro.mentors.domain.services.CreateAvailabilityCalendar
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CreateAvailabilityCalendarTest {

    @Test
    fun `Given passed the entries with the same time on hours and minutes should return a single range of interval`(){
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
        val dateFirst = LocalDateTime.parse("2021-01-01 20:00:08.208812", formatter)
        val dateLast = LocalDateTime.parse("2021-01-01 20:00:08.208812", formatter)

        //val rangeOfDates = CreateAvailabilityCalendar().generateRageDate(dateFirst, dateLast, datesConfig.exceptDays)

       //assertThat(1).isEqualTo(rangeOfDates.size)
    }

    @Test
    fun `Given passed the time with gap of 5 hours from begin to end should return a range of 5 entries`(){
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
        val dateFirst = LocalDateTime.parse("2021-01-01 20:00:08.208812", formatter)
        val dateLast = LocalDateTime.parse("2021-01-02 00:00:08.208812", formatter)

        //val rangeOfDates = CreateAvailabilityCalendar().generateRageDate(dateFirst, dateLast, datesConfig.exceptDays)

        //assertThat(5).isEqualTo(rangeOfDates.size)
    }

    @Test
    fun `Given passed one day of period should return a range of 24 entries`(){
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
        val dateFirst = LocalDateTime.parse("2021-01-01 20:00:08.208812", formatter)
        val dateLast = LocalDateTime.parse("2021-01-02 19:00:08.208812", formatter)

        //val rangeOfDates = CreateAvailabilityCalendar().generateRageDate(dateFirst, dateLast, datesConfig.exceptDays)

        //assertThat(24).isEqualTo(rangeOfDates.size)
    }
}