package com.pro.mentors.rest

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.pro.mentors.rest.plugins.configureRouting
import com.pro.mentors.rest.plugins.configureSecurity

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureRouting()
    }.start(wait = true)
}
