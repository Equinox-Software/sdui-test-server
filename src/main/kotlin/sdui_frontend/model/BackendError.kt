package sdui_frontend.model

import io.ktor.http.*
import kotlinx.serialization.Serializable

@Serializable
data class BackendError(val code:Int, val message:String)

fun BackendError(statusCode: HttpStatusCode, message: String) = BackendError(statusCode.value, message)