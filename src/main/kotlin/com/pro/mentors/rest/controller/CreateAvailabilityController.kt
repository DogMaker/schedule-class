package com.pro.mentors.rest.controller

import com.pro.mentors.domain.entities.Event
import com.pro.mentors.domain.services.CreateAvailabilityCalendar
import com.pro.mentors.rest.config.mapper
import com.pro.mentors.rest.dto.requests.AvailabilityCalendarRequest
import com.pro.mentors.rest.dto.requests.toAvailabilityCalendar


class CreateAvailabilityController {
    fun create(json: String): MutableList<Event> {
        val availabilityCalendar = try {
            mapper().readValue(json, AvailabilityCalendarRequest::class.java)
        }catch (e: Exception) {
            throw RuntimeException("Deserialization fail")
        }

        return CreateAvailabilityCalendar().create(availabilityCalendar.toAvailabilityCalendar())
    }
}