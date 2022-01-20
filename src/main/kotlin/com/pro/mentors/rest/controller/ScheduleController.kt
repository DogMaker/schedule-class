package com.pro.mentors.rest.controller

import com.pro.mentors.domain.entities.Schedule
import com.pro.mentors.domain.services.ScheduleClass
import com.pro.mentors.rest.config.mapper
import com.pro.mentors.rest.dto.requests.ScheduleResponse
import com.pro.mentors.rest.dto.requests.toScheduleResponse

class ScheduleController {
    fun create(json: String): ScheduleResponse {
        val createSchedule = try {
            mapper().readValue(json, Schedule::class.java)
        }catch (e: Exception) {
            throw RuntimeException("Deserialization fail")
        }

        return ScheduleClass().create(createSchedule).toScheduleResponse()
    }
}