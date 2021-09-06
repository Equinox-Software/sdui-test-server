package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*

@Suppress("FunctionName")
inline fun <reified T> CPage(layout: Component, data: T): Page {

  /*  val encodedData = emptyMap<String, JsonElement>().toMutableMap()

    data.forEach { (k, v) ->
        encodedData[k] = SerializeAny().ss(v)

    }

   */

    return Page(layout,  when (data) {
        is String -> Json.encodeToJsonElement(data)
        is Int -> Json.encodeToJsonElement(data)
        is Boolean -> Json.encodeToJsonElement(data)
        is Long ->Json.encodeToJsonElement(data)
    /*    is List<*> -> Json.encodeToJsonElement(ListSerializer(), data)

        ) */
        is Map<*,*> ->

                    Json.encodeToJsonElement(data)


        else -> throw SerializationException("Unsupported Type! Can't serialize $data.")
    }
    )

}

@Serializable
data class Page(val layout: Component, val data:  JsonElement)


