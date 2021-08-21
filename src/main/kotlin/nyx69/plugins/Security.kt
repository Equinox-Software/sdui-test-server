package nyx69.plugins

import io.ktor.auth.*
import io.ktor.util.*
import io.ktor.auth.jwt.*
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.sessions.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import nyx69.ui.Component
import nyx69.ui.LayoutType
import nyx69.ui.WidgetType

fun Application.configureSecurity() {

    authentication {
        jwt {


            val jwtAudience = "jwt.audience"
            realm = "jwt.realm"
            verifier(
                JWT
                    .require(Algorithm.HMAC256("secret"))
                    .withAudience(jwtAudience)
                    .withIssuer("jwt.domain")
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null
            }
        }
    }


    /////
    data class MySession(val count: Int = 0)
    install(Sessions) {
        cookie<MySession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
        }
    }

    routing {
        get("/session/increment") {
            val session = call.sessions.get<MySession>() ?: MySession()
            call.sessions.set(session.copy(count = session.count + 1))
            call.respondText("Counter is ${session.count}. Refresh to increment.")
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
    }
}
