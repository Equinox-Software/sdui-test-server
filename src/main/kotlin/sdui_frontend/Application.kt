package sdui_frontend

import io.ktor.application.Application
import io.ktor.client.features.HttpCallValidator.Companion.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.ContentNegotiation.Feature.install
import io.ktor.server.cio.CIO
import io.ktor.server.engine.ApplicationEngineFactory
import io.ktor.server.engine.embeddedServer
import kotlinx.serialization.json.Json
import org.slf4j.event.Level


fun main() {
    embeddedServer(CIO as ApplicationEngineFactory<*, *>, System.getenv("PORT").toInt()) {
     install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                //     isLenient = true
                ignoreUnknownKeys = true
            })
        }
        /*
              install(CallLogging) {
                  level = Level.INFO
                  filter { call -> call.request.path().startsWith("/") }
              }

              */

      //  configureSecurity()

       // configureRouting()

    }.start(wait = true)


}
