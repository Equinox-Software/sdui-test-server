package nyx69.ui

import kotlinx.serialization.Serializable

@Serializable
data class Component(
    val id: String,
    val type: ComponentType,
    val data: String? = null,
    val children: List<Component>? = null
)

@Suppress("FunctionName")
object Widget{
    fun Text(id: String, text: String) = Component(id, ComponentType.TEXT, text)
    fun EditText(id: String, text: String) = Component(id, ComponentType.TEXT, text)
    fun Image(id: String, url:String) = Component(id, ComponentType.IMAGE, url)
    fun Button(id: String, text: String) = Component(id, ComponentType.BUTTON, text)
}

@Suppress("FunctionName")
object Layout{
    fun Column(id: String, children: List<Component>) = Component(id, ComponentType.VERTICAL, children = children)
    fun LazyColumn(id: String, children: List<Component>) = Component(id, ComponentType.SCROLL_VERTICAL, children = children)
    fun Box(id: String, children: List<Component>) = Component(id, ComponentType.BOX, children = children)
}