package nyx69.ui

import kotlinx.serialization.Serializable

@Serializable
data class Component(
    val id: String,
    val type: ComponentType,
    val data: String? = null,
    val children: List<Component>? = null
)

fun text(id: String, text: String) = Component(id, ComponentType.TEXT, text)

fun column(id: String, children: List<Component>) = Component(id, ComponentType.VERTICAL, children = children)
