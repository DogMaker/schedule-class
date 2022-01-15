package com.pro.mentors.domain.entities


data class Event(
    val eventType: EventType,
    val start: String,
    val end: String
)
