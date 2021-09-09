package sdui_frontend

import io.ktor.application.*
import io.ktor.client.features.HttpCallValidator.Companion.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.cio.CIO
import io.ktor.server.engine.*
import kotlinx.serialization.json.Json
import org.slf4j.event.Level


fun main() { embeddedServer(CIO as ApplicationEngineFactory<*, *>, System.getenv("PORT").toInt(), module = Application::module).start(wait = true)}

fun Application.module(){
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            //     isLenient = true
            ignoreUnknownKeys = true
        })
    }

          install(CallLogging) {
              level = Level.INFO
              filter { call -> call.request.path().startsWith("/") }
          }



    //  configureSecurity()

    // configureRouting()
}
