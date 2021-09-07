package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
import nyx69.ui.ComponentType.*

@Serializable
data class Component(
    val id: String,
    val type: ComponentType,
    val data: JsonElement? = null,
    var children: List<Component>? = null,
    val action: CAction? = null,
    val style: CStyle? = null
)

@Suppress("FunctionName")
object Widget {
    fun CText(id: String, text: String, style: CStyle? = null) =
        Component(id, TEXT, Json.encodeToJsonElement(text), style = style)
    fun CEditText(id: String, text: String) = Component(id, EDIT_TEXT, Json.encodeToJsonElement(text))
    fun CImage(id: String, url: String) = Component(id, IMAGE, Json.encodeToJsonElement(url))
    fun CButton(id: String, text: String, action: CAction.() -> Unit) =
        Component(id, BUTTON, Json.encodeToJsonElement(text), action = CAction().apply(action))
}

@Suppress("FunctionName")
object Layout  {
    fun CLazyColumn(id: String, content: List<Component>) = Component(id, SCROLL_VERTICAL, children = content)
    fun CBox(id: String, content: List<Component>) = Component(id, BOX, children = content)
    fun CColumn(id: String, children: Component.() -> Unit) = Component(id, VERTICAL).apply {
       this. children = listOf(apply(children))
    }

}






