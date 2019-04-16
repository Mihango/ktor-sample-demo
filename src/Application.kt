package com.tech

import io.ktor.application.*
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get {
            call.respondText("Default Response on 8081")
        }

        get("/hello") {
            call.respondText("Hello World")
        }

        post("/hello") {
            call.respondText("Testing post Home")
        }
    }
}

