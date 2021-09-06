package nyx69.ui

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class Page(val layout: Component, val data: Map<String, @Contextual @Serializable Any>)
