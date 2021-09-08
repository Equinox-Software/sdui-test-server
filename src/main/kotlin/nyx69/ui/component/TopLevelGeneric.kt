package nyx69.ui.component

import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType

@Suppress("FunctionName")
object TopLevelGeneric {

    fun AppDivider(
        id: String,
        style: (CStyle.() -> Unit)? = null
    ) = AppComponent(
        id,
        ComponentType.DIVIDER,
        style = style?.let { CStyle().apply(it) })
}