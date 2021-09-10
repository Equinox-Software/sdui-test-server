package sdui_frontend.model

import kotlinx.serialization.*

@Serializable
data class BackendError(val errorCode: Int, val message: String)