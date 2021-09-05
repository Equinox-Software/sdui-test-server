package nyx69.plugins

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.renderComposable
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import nyx69.ktorHttpClient
import nyx69.locations.Profile
import nyx69.locations.Type
import nyx69.ui.*
import nyx69.ui.Layout.CBox
import nyx69.ui.Layout.CColumn
import nyx69.ui.Layout.CLazyColumn
import nyx69.ui.Widget.CButton
import nyx69.ui.Widget.CEditText
import nyx69.ui.Widget.CImage
import nyx69.ui.Widget.CText


@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.configureRouting() {
    install(Locations) {
    }

    val client = ktorHttpClient


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

        get("/melik") {
            call.respond {
                var count: Int by mutableStateOf(0)


                renderComposable(rootElementId = "root") {
                    Div({ style { padding(25.px) } }) {
                        Button(attrs = {
                            onClick { io.ktor.http.count -= 1 }
                        }) {
                            Text("-")
                        }

                        Span({ style { padding(15.px) } }) {
                            Text("${io.ktor.http.count}")
                        }

                        Button(attrs = {
                            onClick { io.ktor.http.count += 1 }
                        }) {
                           Text("+")
                        }
                    }
                }
            }
        }


        get("/cont") {
            call.respond(
                CLazyColumn(
                    "abc", listOf(
                        CText("aa", "Hello!"),
                        CBox(
                            "bb",
                            listOf(
                                CText("ab", "Helooolo!"),
                                CText("ba", "Hellppo!")
                            )
                        ),
                        CButton("122", "click!!"),
                        CButton("112", "click for scrolll!!")
                    )
                )
            )
        }

        post("/click{id}") {

            when (call.parameters["id"]) {
                "122" -> {
                    call.respond(
                        CColumn(
                            "abc", listOf(
                                CImage("ab", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"),
                                CText("ba", "Helltthppo!"),
                                CText("1111", "Umbertoooo"),
                                CEditText("abTuT", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"),
                                CButton("666", "-- click after entering text"),
                                CColumn(
                                    "1122", listOf(
                                        CText("1123", "Helllo"),
                                        CText("1233", "afasgrg")
                                    )
                                ),
                                CButton("777", "get data from DB"),
                            )
                        )
                    )
                }

                "666" -> {
                    call.respond(
                        CColumn(
                            "a6bc",
                            listOf(
                                CImage(
                                    "6ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CText("6pba", "Helltthppo!"),
                                CText("11116", call.receive<Map<String, String>>()["abTuT"].toString()),
                            )


                        )
                    )
                }

                "777" -> {

                    /*  val response = client.post<UserProfile>("click${id}") {

                      } */

                    call.respond(
                        CColumn(
                            "a6bc",
                            listOf(
                                CImage(
                                    "6ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CText("6pba", "DATA FROM DB --- Helltthppo!"),
                                CText("11116", call.receive<Map<String, String>>()["abTuT"].toString()),
                            )


                        )
                    )
                }

                "112" -> {
                    call.respond(
                        CLazyColumn(
                            "abc",
                            listOf(
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CImage(
                                    "ab",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CEditText(
                                    "abTT",
                                    "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                                ),
                                CText("ba", "Helltthppo!")
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
