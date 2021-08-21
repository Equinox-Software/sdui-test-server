package nyx69.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class Component {
    @Serializable
    data class Layout(val id:String,val type: LayoutType, val children: List<Component>)
    @Serializable
    data class Widget (val id:String, val type: WidgetType, val data:String)
}


