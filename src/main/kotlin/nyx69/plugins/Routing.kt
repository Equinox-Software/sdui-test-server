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
import nyx69.ui.Layout.Box
import nyx69.ui.Layout.Column
import nyx69.ui.Layout.LazyColumn
import nyx69.ui.Widget.Button
import nyx69.ui.Widget.EditText
import nyx69.ui.Widget.Image
import nyx69.ui.Widget.Text

@OptIn(KtorExperimentalLocationsAPI::class)
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
                LazyColumn(
                    "abc", listOf(
                        Text("aa", "Hello!"),
                        Box(
                            "bb",
                            listOf(
                                Text("ab", "Helooolo!"),
                                Text("ba", "Hellppo!")
                            )
                        ),
                        Button("122", "click!!"),
                        Button("112", "click for scrolll!!")
                    )
                )
            )
        }

        post("/click{id}") {

            when (call.parameters["id"]) {
                "122" -> {
                    call.respond(
                        Column(
                            "abc", listOf(
                                Image("ab", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"),
                                Text("ba", "Helltthppo!"),
                                Text("1111", "Umbertoooo"),
                                EditText("abTuT", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"),
                                Button("666", "-- click after entering text"),
                                Column(
                                    "1122", listOf(
                                        Text("1123", "Helllo"),
                                        Text("1233", "afasgrg")
                                    )
                                )
                            )
                        )
                    )
                }

                "666" -> {

                    // print("---\n\n${call.receive<Map<String,String>>()["abTuT"].toString()}---")

                    call.respond(
                        Column(
                            "a6bc",
                            listOf(
                                Image(
                                    "6ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Text("6pba", "Helltthppo!"),
                                Text("11116", call.receive<Map<String, String>>()["abTuT"].toString()),
                            )


                        )
                    )
                }

                "112" -> {
                    call.respond(
                        LazyColumn(
                            "abc",
                            listOf(
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Image(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                EditText(
                                    "abTT",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                Text("ba", "Helltthppo!")
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
