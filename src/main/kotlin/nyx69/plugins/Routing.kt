package nyx69.plugins

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import nyx69.locations.Profile
import nyx69.locations.Type
import nyx69.ui.Component
import nyx69.ui.ComponentType
import nyx69.ui.column
import nyx69.ui.text

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
                Component(
                    "abc",
                    ComponentType.SCROLL_VERTICAL,
                    null,
                    listOf(
                        Component("aa", ComponentType.TEXT, "Hello!"),
                        Component(
                            "bb", ComponentType.BOX, null,
                            listOf(
                                Component("ab", ComponentType.TEXT, "Helooolo!"),
                                Component("ba", ComponentType.TEXT, "Hellppo!")
                            )
                        ),
                        Component(
                            "122", ComponentType.BUTTON,
                            "click!!"
                        ),
                        Component(
                            "112", ComponentType.BUTTON,
                            "click for scrolll!!"
                        )
                    )
                )
            )
        }

        get("/click{id}") {

            when (call.parameters["id"]) {
                "122" -> {
                    call.respond(
                        Component(
                            "abc",
                            ComponentType.VERTICAL, null,
                            listOf(
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component("ba", ComponentType.TEXT, "Helltthppo!"),
                                text("1111", "Umbertoooo"),
                                column(
                                    "1122", listOf(
                                        text("1123", "Helllo"),
                                        text("1233", "afasgrg")
                                    )
                                )
                            )


                        )
                    )
                }

                "112" -> {
                    call.respond(
                        Component(
                            "abc",
                            ComponentType.SCROLL_VERTICAL, null,
                            listOf(
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component(
                                    "ab",
                                    ComponentType.IMAGE,
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Component("ba", ComponentType.TEXT, "Helltthppo!")
                            )


                        )
                    )
                }
            }

        }

  /*      authenticate("jwt-auth") {
            get("/auth") {
                call.respondText("Hello World! -- AUTH")
            }
        } */
    }
}
