package nyx69.plugins

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import nyx69.locations.Profile
import nyx69.locations.Type
import nyx69.ui.*
import nyx69.ui.Layout.box
import nyx69.ui.Layout.column
import nyx69.ui.Layout.lazyColumn
import nyx69.ui.Widget.button
import nyx69.ui.Widget.editText
import nyx69.ui.Widget.image
import nyx69.ui.Widget.text

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
                lazyColumn("abc", listOf(
                        text("aa", "Hello!"),
                        box("bb",
                            listOf(
                                text("ab", "Helooolo!"),
                                text("ba",  "Hellppo!")
                            )
                        ),
                        button("122", "click!!"),
                        button("112", "click for scrolll!!")
                    )
                )
            )
        }

        post("/click{id}") {

            when (call.parameters["id"]) {
                "122" -> {
                    call.respond(
                        column(
                            "abc", listOf(
                                image("ab", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"),
                                text("ba", "Helltthppo!"),
                                text("1111", "Umbertoooo"),
                                editText("abTuT", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"),
                                button("666", "-- click after entering text"),
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

                "666" -> {

                    // print("---\n\n${call.receive<Map<String,String>>()["abTuT"].toString()}---")

                    call.respond(
                        column(
                            "a6bc",
                            listOf(
                                image(
                                    "6ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                text("6pba", "Helltthppo!"),
                                text("11116", call.receive<Map<String, String>>()["abTuT"].toString()),
                            )


                        )
                    )
                }

                "112" -> {
                    call.respond(
                        lazyColumn(
                            "abc",
                            listOf(
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                editText(
                                    "abTT",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                text("ba", "Helltthppo!")
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
