package nyx69

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.request.*
import io.ktor.serialization.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import kotlinx.serialization.json.Json
import nyx69.plugins.configureRouting
import nyx69.plugins.configureSecurity
import org.slf4j.event.Level

fun main() {
    embeddedServer(CIO, host = "127.0.0.1", port = /*System.getenv("PORT").toInt()*/8080) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(CallLogging) {
            level = Level.INFO
            filter { call -> call.request.path().startsWith("/") }
        }

        configureSecurity()

        configureRouting() //TODO add JWT

    }.start(wait = true)
}
