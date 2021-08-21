package nyx69.plugins

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import nyx69.locations.Profile
import nyx69.locations.Type
import nyx69.ui.Component
import nyx69.ui.LayoutType
import nyx69.ui.WidgetType

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


        get("/cont") {
            call.respond(
                Component.Layout(
                    "abc",
                    LayoutType.SCROLL_VERTICAL,
                    listOf(
                        Component.Widget("aa", WidgetType.TEXT, "Hello!"),
                        Component.Layout(
                            "bb", LayoutType.BOX,
                            listOf(
                                Component.Widget("ab", WidgetType.TEXT, "Helooolo!"),
                                Component.Widget("ba", WidgetType.TEXT, "Hellppo!")
                            )
                        ),
                        Component.Widget(
                            "122", WidgetType.BUTTON,
                            "click!!"
                        )
                    )
                )
            )
        }

        get("/click{id}") {

            when (call.parameters["id"]) {
                "122" -> {
                    call.respond(
                        Component.Layout(
                            "abc",
                            LayoutType.SCROLL_VERTICAL,
                            listOf(
                                Component.Widget("ab", WidgetType.IMAGE, "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"),
                                Component.Widget("ba", WidgetType.TEXT, "Helltthppo!")
                            )


                        )
                    )
                }
            }

        }

authenticate {
    get("/auth") {
        call.respondText("Hello World! -- AUTH")
    }
}
    }
}
