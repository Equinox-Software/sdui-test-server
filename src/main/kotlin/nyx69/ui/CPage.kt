package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement

@Suppress("FunctionName")
fun CPage(layout:Component, data:Map<String, Any>) = Page(layout,  Json.encodeToJsonElement(data))

@Serializable
data class Page(val layout: Component, val data:  JsonElement)
