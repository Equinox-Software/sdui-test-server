package nyx69.plugins

import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import nyx69.ktorHttpClient
import nyx69.locations.Profile
import nyx69.locations.Type
import nyx69.ui.CStyle
import nyx69.ui.Layout.CBox
import nyx69.ui.Layout.CColumn
import nyx69.ui.Layout.CLazyColumn
import nyx69.ui.Style.CColor
import nyx69.ui.Style.CPadding
import nyx69.ui.Widget.CButton
import nyx69.ui.Widget.CEditText
import nyx69.ui.Widget.CImage
import nyx69.ui.Widget.CText
import nyx69.ui.cccolor
import nyx69.ui.setP
import nyx69.ui.sstyle


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

        get("/cont") {
            call.respond(
                CLazyColumn(
                    "abc", listOf(
                        CText("aa", "Hello!"),
                        CBox(
                            "bb",
                            listOf(
                                CText(
                                    "ab",
                                    "Helooolo!",
                                    style = /*mapOf(
                                        CPadding(200),
                                        CColor(0xFFFF5522)
                                    ) */


                               sstyle {
                                   // CPadding(200)
                                   // CColor(0xFFFF5522)
                                  //  cccolor = 200000L

                             //     padding = listOf(200)

                                   color=0xFFAA66BB
                                }


                                ),
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
