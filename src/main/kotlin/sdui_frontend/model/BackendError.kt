package sdui_frontend.model

import io.ktor.http.*
import kotlinx.serialization.*

@Serializable
data class BackendError(val errorCode: Int, override val message: String)

fun BackendError(statusCode: HttpStatusCode, message: String) = BackendError(statusCode.value, message)