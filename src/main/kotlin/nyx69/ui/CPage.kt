package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*

@Suppress("FunctionName")
inline fun <reified T> CPage(layout: Component, data: T): Page {

  /*  val encodedData = emptyMap<String, JsonElement>().toMutableMap()

    data.forEach { (k, v) ->
        encodedData[k] = SerializeAny().ss(v)

    }

   */

    return Page(layout, Json.encodeToJsonElement(data))
}

@Serializable
data class Page(val layout: Component, val data:  JsonElement)


