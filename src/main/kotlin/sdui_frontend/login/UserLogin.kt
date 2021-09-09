package sdui_frontend.login

import io.ktor.auth.*
import kotlinx.serialization.Serializable

@Serializable
data class UserLogin(val username: String, val password: String): Principal