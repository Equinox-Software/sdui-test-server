package sdui_frontend

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.request.*
import io.ktor.serialization.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import kotlinx.serialization.json.*
import org.slf4j.event.*
import sdui_frontend.plugins.*


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

   configureRouting()
}
