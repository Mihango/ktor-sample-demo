package com.tech

import com.tech.models.Address
import com.tech.models.Customer
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.Parameters
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import java.text.DateFormat

fun Application.customer(testing: Boolean = true) {

    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }

        routing {
            post("/customer") {
                val customer = call.receive<Customer>()
                call.respond(customer)
            }

            get("/customer") {
                val p: String? = call.request.queryParameters["name"]
                if(p == null) {
                    call.respond(Any())
                } else {
                    val customer = Customer("Rhyan Mihang'o", Address("120", "302", "Lower Kabete"))
                    call.respond(customer)
                }
            }
        }

    }
}
