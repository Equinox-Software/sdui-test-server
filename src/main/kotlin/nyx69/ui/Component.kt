package nyx69.ui

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
import nyx69.ui.ComponentType.*

@Suppress("FunctionName")
@Serializable
data class Component(
    val id: String,
    val type: ComponentType,
    val data: JsonElement? = null,
    var children: MutableList<Component>? = null,
    val action: CAction? = null,
    val style: CStyle? = null
) {
    fun CEditText(id: String, text: String) = this.children?.add(Widget.CEditText(id, text))
    fun CImage(id: String, url: String) = this.children?.add(Widget.CImage(id, url))
    fun CButton(id: String, text: String, action: CAction.() -> Unit) = this.children?.add(Widget.CButton(id, text, action))
    fun CText(id: String, text: String, style: (CStyle.() -> Unit)? = null) = this.children?.add(Widget.CText(id, text, style))
    fun CLazyColumn(id: String, content: Component.() -> Unit) = this.children?.add(Layout.CLazyColumn(id, content))
    fun CBox(id: String, content: Component.() -> Unit) = this.children?.add(Layout.CBox(id, content))
    fun CColumn(id: String, content: Component.() -> Unit) = this.children?.add(Layout.CColumn(id, content))
}

@Suppress("FunctionName")
object Widget {
    fun CText(id: String, text: String, style: (CStyle.() -> Unit)? = null) = Component(id, TEXT, Json.encodeToJsonElement(text), style = style?.let { CStyle().apply(it) })
    fun CEditText(id: String, text: String) = Component(id, EDIT_TEXT, Json.encodeToJsonElement(text))
    fun CImage(id: String, url: String) = Component(id, IMAGE, Json.encodeToJsonElement(url))
    fun CButton(id: String, text: String, action: CAction.() -> Unit) = Component(id, BUTTON, Json.encodeToJsonElement(text), action = CAction().apply(action))
}

@Suppress("FunctionName")
object Layout {
    fun CLazyColumn(id: String, content: Component.() -> Unit) = Component(id, SCROLL_VERTICAL, children = mutableListOf()).apply(content)
    fun CBox(id: String, content: Component.() -> Unit) = Component(id, BOX, children = mutableListOf()).apply(content)
    fun CColumn(id: String, content: Component.() -> Unit) = Component(id, VERTICAL, children = mutableListOf()).apply(content)
}

//maybe let Layout/Widget extend Component and just pass own classes for any of that