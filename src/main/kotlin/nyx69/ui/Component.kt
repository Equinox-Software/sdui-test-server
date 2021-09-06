package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
import nyx69.ui.ComponentType.*
import nyx69.ui.ComponentActionType.*

@Serializable
data class Component(
    val id: String,
    val type: ComponentType,
    val data: JsonElement? = null,
    val children: List<Component>? = null,
    val actions: Map<ComponentActionType, JsonElement>? = null,
    val styles: List<ComponentStyle>? = null
)

@Suppress("FunctionName")
object Widget {
    fun CText(id: String, text: String, styles:  List<ComponentStyle>? = null): Component {
        return Component(id, TEXT, Json.encodeToJsonElement(text), styles = styles)
    }

    fun CEditText(id: String, text: String) = Component(id, TEXT, Json.encodeToJsonElement(text))
    fun CImage(id: String, url: String) = Component(id, IMAGE, Json.encodeToJsonElement(url))
    fun CButton(id: String, text: String) =
        Component(id, BUTTON, Json.encodeToJsonElement(text), actions = mapOf(CLICK to Json.encodeToJsonElement("id")))
}

@Suppress("FunctionName")
object Layout {
    fun CColumn(id: String, children: List<Component>) = Component(id, VERTICAL, children = children)
    fun CLazyColumn(id: String, children: List<Component>) =
        Component(id, SCROLL_VERTICAL, children = children)

    fun CBox(id: String, children: List<Component>) = Component(id, BOX, children = children)
}