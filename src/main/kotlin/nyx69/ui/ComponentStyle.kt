package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement

@Serializable
data class ComponentStyle(val type: ComponentStyleType, val value: JsonElement? = null)

@Suppress("FunctionName")
object Style {
    fun CPadding(all: Int) = CPadding(all, all, all, all)
    fun CPadding(vertical: Int, horizontal: Int) = CPadding(vertical, horizontal, vertical, horizontal)
    fun CPadding(start: Int, top: Int, end: Int, bottom: Int) =
        ComponentStyle(ComponentStyleType.PADDING, Json.encodeToJsonElement(listOf(start, top, end, bottom)))

    fun CColor(color: Long) = ComponentStyle(ComponentStyleType.COLOR, Json.encodeToJsonElement(color))
}
