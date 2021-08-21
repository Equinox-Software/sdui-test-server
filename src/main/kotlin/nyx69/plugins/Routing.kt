package nyx69.plugins

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import nyx69.locations.Profile
import nyx69.locations.Type

fun Application.configureRouting() {
    install(Locations) {
    }

    routing {
        get("/") {
                call.respondText("Hello World!")
            }
        get<Profile> {
                call.respondText("Location: name=${it.name}, arg1=${it.arg1}, arg2=${it.arg2}")
            }
            // Register nested routes
            get<Type.Edit> {
                call.respondText("Inside $it")
            }
            get<Type.List> {
                call.respondText("Inside $it")
            }

authenticate {
    get("/auth") {
        call.respondText("Hello World! -- AUTH")
    }
}
    }
}
