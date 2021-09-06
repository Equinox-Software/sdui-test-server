package nyx69.ui

import io.ktor.util.reflect.*
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*

@Suppress("FunctionName")
fun <T> CPage(layout: Component, data: Map<String,T>): Page<T> {

  /*  val encodedData = emptyMap<String, JsonElement>().toMutableMap()

    data.forEach { (k, v) ->
        encodedData[k] = SerializeAny().ss(v)

    }

   */

    return Page(layout, data)
}

@Serializable
data class Page<out T>(val layout: Component, val data: Map<String, T>)
