package sdui_frontend.plugins

import io.ktor.application.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import sdui_frontend.*
import sdui_frontend.locations.*
import sdui_frontend.locations.Type
import sdui_frontend.login.*
import sdui_frontend.ui.component.TopLevelLayout.AppColumn
import sdui_frontend.ui.component.TopLevelLayout.AppLazyColumn
import sdui_frontend.ui.style.*


@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.configureRouting() {

    install(Locations)

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
                    AppColumn(
                        "abc"
                    ) {
                        AppEditText("abTuT", "some zzTexttt")
                        AppBox("", style = {
                            padding(200)
                            color = 0xFF553345
                        }) {
                            AppText("aa", "AAjjjjjAAAAA")
                            AppText("aa", "AAAAAkkkkkkkkkkkAA")
                        }
                        AppEditText("abTuT", "someio Texttt")
                        AppText("aa", "AAAAAAA")
                        AppBox("bb") {
                            AppText(
                                "ab",
                                "Helooolo!",
                            ) {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            AppText("ba", "Hellppo!")
                        }
                        AppButton("122", "click!!") {
                            click = "333"
                        }
                        AppButton("112", "click for scrolll!!") {
                            click = "333"
                        }
                    }
                )
            }

            get("b") {
                call.respond(
                    AppColumn(
                        "abc", style = {
                            padding(30)
                        }
                    ) {
                        AppText("aa", " --- BBB ---")
                        AppBox(
                            "bb"
                        ) {
                            AppText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            AppText("ba", "Hellppo!")
                        }
                        AppButton("122", "navigate") {
                            navigate = "c"
                        }
                        AppDivider("kkk")
                        AppButton("122", "click!!") {
                            click = "333"
                        }
                        AppDivider("kkk") {
                            padding(20, 80)
                        }
                        AppButton("112", "click for scrolll!!") {
                            navigate = "d"
                        }
                    }
                )
            }

            get("c") {

                call.respond(
                    AppLazyColumn("abc") {
                        AppText("aa", "--- CCC ---")
                        AppBox("bb") {
                            AppText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            AppText("ba", "Hellppo!")
                        }
                        AppButton("122", "click!!") {
                            click = "333"
                        }
                        AppBox("bb") {
                            AppText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            AppText("ba", "Hellppo!")
                        }
                        AppButton("122", "click!!") {
                            click = "333"
                        }
                        AppBox("bb") {
                            AppText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            AppText("ba", "Hellppo!")
                        }
                        AppButton("122", "click!!") {
                            click = "333"
                        }
                        AppBox("bb") {
                            AppText("ab", "Helooolo!") {
                                color = 0xFFAA66BB
                                padding(40)
                            }
                            AppText(
                                "ba",
                                "HellpHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppoHellppopo!"
                            ) {
                                width = FILL
                                height = 50
                            }
                        }
                        AppLazyRow("afggefgfe", style = {
                            width = FILL
                        }) {
                            (0..15).forEach {
                                AppText("ba", "Hellppo!- $it")
                            }
                        }
                        AppButton("122", "click!!") {
                            click = "333"
                        }
                        AppButton("112", "click for AAa!!") {
                            navigate = "a"
                        }
                    }
                )
            }

            get("d") {
                call.respond(
                    AppLazyColumn("abc", style = {
                        width = FILL
                    }) {
                        (0..15).forEach {
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            ) {
                                height = 90
                                width = 160
                            }
                            AppText("ba", "Image $it")
                        }

                        AppDivider("dfef") {
                            height = 10
                            width = 100
                            padding(12)
                        }

                        AppLazyRow("afggefgfe", style = {
                            width = FILL
                            padding(45, 0)
                        }) {
                            (0..20).forEach {
                                AppColumn("ffff") {
                                    AppText("YEEEE", "ROW ROW")
                                    AppText("YEEEE", "ROW lelelel ROW") {
                                        color = if (it % 2 == 0) 0xFF662234 else 0xFF887744
                                    }
                                    AppText("YEEEE", "rowItem $it")
                                }
                            }

                        }

                        AppEditText(
                            "abTT",
                            "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                        )
                        AppText("ba", "Helltthppo!")
                    }
                )
            }
        }

        route("auth") {
            post("login") {

                val user = call.receive<UserLogin>()

                try {
                    val tokenRequest: HttpResponse = client.post("auth/login") {
                        body = user
                    }

                    if (tokenRequest.status == HttpStatusCode.OK) {
                        print("---------------- Login valid. Sending routes...")
                        val token: String? = tokenRequest.receive<Map<String, String>>()["token"]
                        token?.let {
                            //TODO validity should come from server :P
                            call.respond(RouteTokenResponse(it, 50000, listOf("a", "b", "c", "d")))
                        } ?: call.respond(HttpStatusCode.InternalServerError, "Received no token.")
                    } else
                        call.respond(tokenRequest.request)
                } catch (e: Throwable) {

                    call.respond(HttpStatusCode.InternalServerError, "uh oh")
                }

                //also needs to handler User-NOTEXIST and Pasword being wrong.

            }
        }





        post("/click{id}") {

            when (call.parameters["id"]) {
                "122" -> {
                    call.respond(
                        AppColumn(
                            "abc"
                        ) {
                            AppEditText("abTuT", "some Texttt")
                            AppImage("ab", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg")
                            AppText("ba", "Helltthppo!") {
                                padding(25, 77)
                            }
                            AppText("1111", "Umbertoooo") {
                                padding(24, 56)
                            }
                            AppEditText("abTuT", "some Texttt")
                            AppButton("666", "-- click after entering text") {
                                click = "333"
                            }
                            AppColumn("1122") {
                                AppText("1123", "Helllo")
                                AppText("1233", "afasgrg")
                            }
                            AppButton("777", "get data from DB") {
                                click = "333"
                            }
                        }
                    )
                }

                "666" -> {
                    val texxxxt = call.receive<Map<String, String>>()["abTuT"].toString()

                    call.respond(
                        AppColumn(
                            "a6bc"
                        ) {
                            AppImage("6ab", "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg")
                            AppText("6pba", "Helltthppo!")
                            AppText("11116", texxxxt)
                        })
                }

                "777" -> {

                    /*  val response = client.post<UserProfile>("click${id}") {

                  } */

                    val texxt = call.receive<Map<String, String>>()["abTuT"].toString()

                    call.respond(
                        AppColumn("a6bc") {
                            AppImage(
                                "6ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppText("6pba", "DATA FROM DB --- Helltthppo!")
                            AppText("11116", texxt)
                        }
                    )
                }

                "112" -> {
                    call.respond(
                        AppLazyColumn("abc") {
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppImage(
                                "ab",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppEditText(
                                "abTT",
                                "https://cdn.wallpapersafari.com/46/29/MTLnRp.jpg"
                            )
                            AppText("ba", "Helltthppo!")
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