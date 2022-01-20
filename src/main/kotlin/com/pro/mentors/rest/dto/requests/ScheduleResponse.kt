package com.pro.mentors.rest.dto.requests

import com.pro.mentors.domain.entities.EventType
import com.pro.mentors.domain.entities.Schedule


data class ScheduleResponse(
    val eventId: Int,
    val eventBlock: EventType,
    val start: String,
    val end: String
)

fun Schedule.toScheduleResponse() = ScheduleResponse(
    this.eventId,
    this.eventBlock,
    this.start.toString(),
    this.end.toString()
)