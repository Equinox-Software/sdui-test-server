package nyx69.ui

import io.ktor.util.reflect.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*

@Suppress("FunctionName")
fun CPage(layout: Component, data: Map<String, Any>): Page {

    val encodedData = emptyMap<String, JsonElement>().toMutableMap()

    data.forEach { (k, v) ->

        print("-- INSTANCE:: "+ v.instanceOf(String::class))

        val isStr = (v is String)

        print("-- IS:: $isStr")

        encodedData[k] =
            when (v) {
                   String -> {
                    Json.encodeToJsonElement(v)
                }
                 Int -> {
                    Json.encodeToJsonElement(v)
                }
                 Boolean -> {
                    Json.encodeToJsonElement(v)
                }
                Long -> {
                    Json.encodeToJsonElement(v)
                }

                else -> {

                    Json.encodeToJsonElement("No value found")
                }
            }
    }

    return Page(layout, encodedData)
}

@Serializable
data class Page(val layout: Component, val data: Map<String, JsonElement>)
