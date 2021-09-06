package nyx69.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class ComponentStyle(val type: ComponentStyleType) {
    data class Padding(val start: Int, val top: Int, val end: Int, val bottom: Int) : ComponentStyle(ComponentStyleType.PADDING)
    data class Color(val color: Long) : ComponentStyle(ComponentStyleType.COLOR)
}

fun padding(all: Int) = ComponentStyle.Padding(all, all, all, all)
fun padding(vertical: Int,  horizontal: Int)  = ComponentStyle.Padding(vertical, horizontal, vertical, horizontal)
