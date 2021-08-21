package nyx69

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.request.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import nyx69.plugins.*
import org.slf4j.event.Level

fun main() {
    embeddedServer(CIO, port = 9090, host = "127.0.0.1") {
        install(ContentNegotiation) {
            json()
        }

        install(CallLogging) {
            level = Level.INFO
            filter { call -> call.request.path().startsWith("/") }
        }

        configureSecurity()

        configureRouting()

    }.start(wait = true)
}
