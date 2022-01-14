package com.pro.mentors.domain.entities

enum class EventType(val status: String) {
    BUSY("red"),
    FREE("green"),
    BLOCK("grey")
}