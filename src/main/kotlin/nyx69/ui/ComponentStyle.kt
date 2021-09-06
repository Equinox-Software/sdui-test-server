package nyx69.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class ComponentStyle(val type: ComponentStyleType) {
    data class PaddingAll(val all: Int) : ComponentStyle.Padding(all, all, all, all)
    open class Padding(top: Int, start: Int, end: Int, bottom: Int) : ComponentStyle(ComponentStyleType.PADDING)
    data class Color(val color: Long) : ComponentStyle(ComponentStyleType.COLOR)
}
