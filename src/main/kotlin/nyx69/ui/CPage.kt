package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class CPage(val layout: Component, val data: Map<String, JsonPrimitive>)
