package nyx69.ui

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.encodeToJsonElement

//fun CPage(layout:Component, data:Map<String, Any>) = Page(layout, data.map { k,v -> Json.encodeToJsonElement(v) })

@Serializable
data class Page(val layout: Component, val data: Map<String, JsonElement>)
