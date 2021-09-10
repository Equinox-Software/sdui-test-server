package sdui_frontend.ui.style

import io.ktor.util.*
import kotlinx.serialization.*

@Serializable
data class CStyle(
    @InternalAPI var padding: List<Int>? = null,
    var color: Long? = null,
    var width: Int? = null,
    var height: Int? = null
) {
    @OptIn(InternalAPI::class)
    fun padding(all: Int) {
        padding = listOf(all, all, all, all)
    }

    @OptIn(InternalAPI::class)
    fun padding(vertical: Int=0, horizontal: Int=0) {
        padding = listOf(vertical, horizontal, vertical, horizontal)
    }

    @OptIn(InternalAPI::class)
    fun padding(start: Int=0, top: Int=0, end: Int=0, bottom: Int=0) {
        padding = listOf(start, top, end, bottom)
    }

}

const val FILL = -1



