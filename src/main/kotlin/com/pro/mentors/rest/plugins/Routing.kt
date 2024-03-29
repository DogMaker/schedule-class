package com.pro.mentors.rest.plugins

import com.pro.mentors.rest.config.mapper
import com.pro.mentors.rest.controller.CreateAvailabilityController
import com.pro.mentors.rest.controller.ScheduleController
import io.ktor.content.*
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    routing {
        post("/create-range") {
            val customer = call.receiveText()
            val resp = CreateAvailabilityController().create(customer)

            val json = mapper().writeValueAsString(resp)

            call.respond(
                TextContent(
                    json,
                    ContentType.Application.Json,
                    HttpStatusCode.Created
                )
            )
        }

        post("/create-schedule") {
            val customer = call.receiveText()
            val resp = ScheduleController().create(customer)

            val json = mapper().writeValueAsString(resp)

            call.respond(
                TextContent(
                    json,
                    ContentType.Application.Json,
                    HttpStatusCode.Created
                )
            )
        }
    }
}