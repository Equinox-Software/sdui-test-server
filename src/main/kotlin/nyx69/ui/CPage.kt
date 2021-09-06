package nyx69.ui

import io.ktor.util.reflect.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*

@Suppress("FunctionName")
fun CPage(layout: Component, data: Map<String, Any>): Page {

    val encodedData = emptyMap<String, JsonElement>().toMutableMap()

    data.forEach { (k, v) ->
        encodedData[k] =
            when (v) {
                is String -> Json.encodeToJsonElement(v)
                is Int -> Json.encodeToJsonElement(v)
                is Boolean -> Json.encodeToJsonElement(v)
                is Long -> Json.encodeToJsonElement(v)
                else -> Json.encodeToJsonElement("No value found")
            }
    }

    return Page(layout, encodedData)
}

@Serializable
data class Page(val layout: Component, val data: Map<String, JsonElement>)
