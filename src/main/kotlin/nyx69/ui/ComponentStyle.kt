package nyx69.ui

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

@Suppress("FunctionName")
object Style {
    fun CPadding(all: Int) = CPadding(all, all, all, all)
    fun CPadding(vertical: Int, horizontal: Int) = CPadding(vertical, horizontal, vertical, horizontal)
    fun CPadding(start: Int, top: Int, end: Int, bottom: Int) =
        Pair(ComponentStyleType.PADDING, Json.encodeToJsonElement(listOf(start, top, end, bottom)))

    fun CColor(color: Long) = Pair(ComponentStyleType.COLOR, Json.encodeToJsonElement(color))
}
