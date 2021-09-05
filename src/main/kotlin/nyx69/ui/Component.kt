package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class Component(
    val id: String,
    val type: ComponentType,
    val data: Map<String, JsonPrimitive>? = null,
    val children: List<Component>? = null
)

@Suppress("FunctionName")
object Widget {
    fun CText(id: String, text: String) = Component(id, ComponentType.TEXT, text)
    fun CEditText(id: String, text: String) = Component(id, ComponentType.TEXT, text)
    fun CImage(id: String, url: String) = Component(id, ComponentType.IMAGE, url)
    fun CButton(id: String, text: String) = Component(id, ComponentType.BUTTON, text)
}

@Suppress("FunctionName")
object Layout {
    fun CColumn(id: String, children: List<Component>) = Component(id, ComponentType.VERTICAL, children = children)
    fun CLazyColumn(id: String, children: List<Component>) =
        Component(id, ComponentType.SCROLL_VERTICAL, children = children)

    fun CBox(id: String, children: List<Component>) = Component(id, ComponentType.BOX, children = children)
}