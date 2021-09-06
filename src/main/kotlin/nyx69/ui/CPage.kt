package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*

@Suppress("FunctionName")
fun CPage(layout: Component, data: CData): Page {

    /*  val encodedData = emptyMap<String, JsonElement>().toMutableMap()

      data.forEach { (k, v) ->
          encodedData[k] = SerializeAny().ss(v)

      }

     */

    return Page(
        layout, when (data) {
            is CData.CString -> Json.encodeToJsonElement(data.value)
            is CData.CInt -> Json.encodeToJsonElement(data.value)
            is CData.CBoolean -> Json.encodeToJsonElement(data.value)
            is CData.CLong -> Json.encodeToJsonElement(data.value)
            /*    is List<*> -> Json.encodeToJsonElement(ListSerializer(), data)

                ) */
            is CData.CMap -> Json.encodeToJsonElement(data.map)
            is CData.CMapStr -> Json.encodeToJsonElement(data.map)
            is CData.CList -> Json.encodeToJsonElement(data.list)

        }
    )
}

@Serializable
sealed class CData {
    data class CString(val value: String) : CData()
    data class CInt(val value: Int) : CData()
    data class CBoolean(val value: Boolean) : CData()
    data class CLong(val value: Long) : CData()
    data class CList(val list: List<String>) : CData()
    data class CMapStr(val map: Map<String, String>) : CData()
    data class CMap(val map: Map<String, CData>) : CData()
}


@Serializable
data class Page(val layout: Component, val data: JsonElement)


