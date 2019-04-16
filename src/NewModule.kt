package com.tech

import io.ktor.application.Application
import io.ktor.application.ApplicationCallPipeline
import io.ktor.application.call
import io.ktor.features.origin
import io.ktor.request.uri
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

fun Application.newModule(testing: Boolean = true) {
    // testing interceptors
    routing {
        intercept(ApplicationCallPipeline.Call) {
            if(call.request.uri == "/intercept") {
                // call.respondText("Responding interceptor")
                call.response.headers.append("origin", call.request.origin.remoteHost)
                call.response.headers.append("status", "200")
            }
        }
        get("/intercept") {
            call.respondText("Testing interceptor")
        }
    }
}
