package com.pro.mentors.rest

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.pro.mentors.rest.plugins.configureRouting
import com.pro.mentors.rest.plugins.configureSecurity
import io.ktor.server.plugins.*
import io.ktor.server.application.*
import io.ktor.http.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(CORS) {
            method(HttpMethod.Options)
            method(HttpMethod.Post)
            exposeHeader(HttpHeaders.AccessControlAllowOrigin)
            header(HttpHeaders.AccessControlAllowOrigin)
            allowSameOrigin = true
            allowNonSimpleContentTypes = true
            anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
        }
        configureSecurity()
        configureRouting()
    }.start(wait = true)
}
