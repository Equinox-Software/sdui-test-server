package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
import nyx69.ui.ComponentActionType.CLICK
import nyx69.ui.ComponentType.*

@Serializable
data class Component(
    val id: String,
    val type: ComponentType,
    val data: JsonElement? = null,
    var children: List<Component>? = null,
    val actions: Map<ComponentActionType, JsonElement>? = null,
    val style: CStyle? = null
)

@Suppress("FunctionName")
object Widget {
    fun CText(id: String, text: String, style: CStyle? = null) =
        Component(id, TEXT, Json.encodeToJsonElement(text), style = style)

    fun CEditText(id: String, text: String) = Component(id, EDIT_TEXT, Json.encodeToJsonElement(text))
    fun CImage(id: String, url: String) = Component(id, IMAGE, Json.encodeToJsonElement(url))
    fun CButton(id: String, text: String) =
        Component(id, BUTTON, Json.encodeToJsonElement(text), actions = mapOf(CLICK to Json.encodeToJsonElement("id")))
}

@Suppress("FunctionName")
object Layout {
    // fun CColumn(id: String, content: Component.() -> Unit) = Component(id, VERTICAL).apply(content)
    fun CLazyColumn(id: String, content: List<Component>) =
        Component(id, SCROLL_VERTICAL, children = content)
    fun CBox(id: String, content: List<Component>) = Component(id, BOX, children = content)

    fun CColumn(id: String, content: List<Component>) = Component(id, VERTICAL, children = content)

}






