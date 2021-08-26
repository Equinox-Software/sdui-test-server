package nyx69.ui

import kotlinx.serialization.Serializable

@Serializable
data class Component(
    val id: String,
    val type: ComponentType,
    val data: String? = null,
    val children: List<Component>? = null
)

object Widget{
    fun text(id: String, text: String) = Component(id, ComponentType.TEXT, text)
    fun editText(id: String, text: String) = Component(id, ComponentType.TEXT, text)
    fun image(id: String,url:String) = Component(id, ComponentType.IMAGE, url)
    fun button(id: String, text: String) = Component(id, ComponentType.BUTTON, text)
}

object Layout{
    fun column(id: String, children: List<Component>) = Component(id, ComponentType.VERTICAL, children = children)
    fun lazyColumn(id: String, children: List<Component>) = Component(id, ComponentType.SCROLL_VERTICAL, children = children)
    fun box(id: String, children: List<Component>) = Component(id, ComponentType.BOX, children = children)
}






