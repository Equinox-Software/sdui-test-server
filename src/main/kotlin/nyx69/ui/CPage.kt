package nyx69.ui

import io.ktor.util.reflect.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*

@Suppress("FunctionName")
fun CPage(layout: Component, data: Map<String,@Serializable(AnySerializer::class) Any>): Page {

  /*  val encodedData = emptyMap<String, JsonElement>().toMutableMap()

    data.forEach { (k, v) ->
        encodedData[k] = SerializeAny().ss(v)

    }

   */

    return Page(layout, data)
}

@Serializable
data class Page(val layout: Component, val data: Map<String, @Serializable(AnySerializer::class)Any>)
