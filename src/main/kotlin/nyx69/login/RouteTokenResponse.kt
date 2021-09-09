package nyx69.login

import kotlinx.serialization.Serializable

@Serializable
data class RouteTokenResponse(
val token:String,
val validUntil: Long,
val routes: List<String>
)
