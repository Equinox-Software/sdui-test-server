package sdui_frontend.login

import kotlinx.serialization.*

@Serializable
data class RouteTokenResponse(
    val token: String,
    val validUntil: Long,
    val routes: List<String>
)
