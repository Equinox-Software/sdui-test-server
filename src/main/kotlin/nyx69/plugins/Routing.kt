package nyx69.plugins

import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import nyx69.ktorHttpClient
import nyx69.locations.Profile
import nyx69.locations.Type
import nyx69.ui.CBox
import nyx69.ui.CCBox
import nyx69.ui.CCText
import nyx69.ui.CText
import nyx69.ui.Layout.CColumn
import nyx69.ui.Layout.CLazyColumn


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

        route("content") {
            get("a") {
                call.respond(
                    CColumn(
                        "abc"
                    ) {
                        CEditText("abTuT", "some zzTexttt")


                        CCBox("",style = {
                            padding(200)
                            color = 0xFF553345
                        }){
                        }

                        CEditText("abTuT", "someio Texttt")
                        CCText("aa", "AAAAAAA")
                        CBox("bb") {
                            CText(
                                "ab",
                                "Helooolo!",
                            ) {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            CText("ba", "Hellppo!")
                        }
                        CButton("122", "click!!") {
                            click = "333"
                        }
                        CButton("112", "click for scrolll!!") {
                            click = "333"
                        }
                    }
                )
            }

            get("b") {
                call.respond(
                    CColumn(
                        "abc"
                    ) {
                        CText("aa", " --- BBB ---")
                        CBox(
                            "bb"
                        ) {
                            CText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            CText("ba", "Hellppo!")
                        }
                        CButton("122", "navigate") {
                            navigate = "c"
                        }
                        CButton("122", "click!!") {
                            click = "333"
                        }
                        CButton("112", "click for scrolll!!") {
                            navigate = "d"
                        }
                    }
                )
            }

            get("c") {

                call.respond(
                    CLazyColumn("abc") {
                        CText("aa", "--- CCC ---")
                        CBox("bb") {
                            CText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            CText("ba", "Hellppo!")
                        }
                        CButton("122", "click!!") {
                            click = "333"
                        }
                        CBox("bb") {
                            CText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            CText("ba", "Hellppo!")
                        }
                        CButton("122", "click!!") {
                            click = "333"
                        }
                        CBox("bb") {
                            CText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            CText("ba", "Hellppo!")
                        }
                        CButton("122", "click!!") {
                            click = "333"
                        }
                        CBox("bb") {
                            CText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            CText("ba", "Hellppo!")
                        }
                        CButton("122", "click!!") {
                            click = "333"
                        }
                        CButton("112", "click for scrolll!!") {
                            click = "333"
                        }
                    }
                )
            }

            get("d") {
                call.respond(
                    CLazyColumn("abc") {
                        (0..15).forEach {
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                        }

                        CEditText(
                            "abTT",
                            "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                        )
                        CText("ba", "Helltthppo!")
                    }
                )
            }
        }

        get("routes") {
            call.respond(listOf("a", "b", "c", "d"))
        }

        post("/click{id}") {

            when (call.parameters["id"]) {
                "122" -> {
                    call.respond(
                        CColumn(
                            "abc"
                        ) {
                            CEditText("abTuT", "some Texttt")
                            CImage("ab", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg")
                            CText("ba", "Helltthppo!") {
                                padding(25, 77)
                            }
                            CText("1111", "Umbertoooo") {
                                padding(24, 56)
                            }
                            CEditText("abTuT", "some Texttt")
                            CButton("666", "-- click after entering text") {
                                click = "333"
                            }
                            CColumn("1122") {
                                CText("1123", "Helllo")
                                CText("1233", "afasgrg")
                            }
                            CButton("777", "get data from DB") {
                                click = "333"
                            }
                        }
                    )
                }

                "666" -> {
                    val texxxxt = call.receive<Map<String, String>>()["abTuT"].toString()

                    call.respond(
                        CColumn(
                            "a6bc"
                        ) {
                            CImage("6ab", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg")
                            CText("6pba", "Helltthppo!")
                            CText("11116", texxxxt)
                        })
                }

                "777" -> {

                    /*  val response = client.post<UserProfile>("click${id}") {

                  } */

                    val texxt = call.receive<Map<String, String>>()["abTuT"].toString()

                    call.respond(
                        CColumn("a6bc") {
                            CImage(
                                "6ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CText("6pba", "DATA FROM DB --- Helltthppo!")
                            CText("11116", texxt)
                        }
                    )
                }

                "112" -> {
                    call.respond(
                        CLazyColumn("abc") {
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CEditText(
                                "abTT",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            CText("ba", "Helltthppo!")
                        }
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