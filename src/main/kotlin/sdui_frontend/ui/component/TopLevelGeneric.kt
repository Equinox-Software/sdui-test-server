package sdui_frontend.ui.component

import sdui_frontend.ui.style.*
import sdui_frontend.ui.type.*

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