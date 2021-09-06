package nyx69.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class ComponentStyle(val type: ComponentStyleType) {
    data class PaddingAll(val all: Int) : ComponentStyle.Padding(all, all, all, all)
    data class PaddingDirectional(val vertical: Int, val horizontal: Int) :
        ComponentStyle.Padding(vertical, horizontal, vertical, horizontal)

    open class Padding(start: Int, top: Int, end: Int, bottom: Int) : ComponentStyle(ComponentStyleType.PADDING)
    data class Color(val color: Long) : ComponentStyle(ComponentStyleType.COLOR)
}
