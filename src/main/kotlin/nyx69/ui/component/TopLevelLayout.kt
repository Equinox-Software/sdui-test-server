package nyx69.ui.component

import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType.*

@Suppress("FunctionName")
object TopLevelLayout {
    fun AppLazyColumn(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        children: AppComponent.() -> Unit
    ) =
        AppComponent(
            id,
            SCROLL_VERTICAL,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(children)

    fun AppBox(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        children: AppComponent.() -> Unit
    ) =
        AppComponent(
            id,
            BOX,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(children)

    fun AppColumn(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        children: AppComponent.() -> Unit
    ) =
        AppComponent(
            id,
            VERTICAL,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(children)
}