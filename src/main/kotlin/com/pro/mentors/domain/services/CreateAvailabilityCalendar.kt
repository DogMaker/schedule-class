package com.pro.mentors.domain.services

import com.pro.mentors.domain.entities.AvailabilityCalendar
import com.pro.mentors.domain.entities.EventType
import java.time.DayOfWeek
import java.time.LocalDateTime

class CreateAvailabilityCalendar {
    val req = "{ \"id\": 12,\"title\": \"\",\"eventType\": \"FREE\",\"start\": \"2022-01-13T22:59:15.791\",\"end\": \"2022-01-13T22:59:15.796\",\"exceptDays\": [\"SUNDAY\", \"SATURDAY\"],\"exceptTimes\": [\"2022-01-13T22:59:15.842\"] }"


    fun create(){
        val created = AvailabilityCalendar(12,"",EventType.FREE, LocalDateTime.now(), LocalDateTime.now(),
        listOf(DayOfWeek.SUNDAY,DayOfWeek.SATURDAY), listOf(LocalDateTime.now())
        )

        println(created)
    }
}

fun main() {
    CreateAvailabilityCalendar().create()
}