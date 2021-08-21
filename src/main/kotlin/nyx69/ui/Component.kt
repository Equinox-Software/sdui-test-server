package nyx69.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class Component(open val id:String) {
    data class Layout(override val id:String, val type: LayoutType, val children: List<Component>): Component(id)
    data class Widget (override val id:String, val type: WidgetType, val data:String) : Component(id)
}


