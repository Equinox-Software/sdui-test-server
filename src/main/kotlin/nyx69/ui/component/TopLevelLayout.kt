package nyx69.ui.component

import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType.*
import nyx69.ui.component.AppComponent.AppLayout

@Suppress("FunctionName")
object TopLevelLayout {
    fun AppLazyColumn(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppLayout.() -> Unit
    ) =
        AppLayout(
            id,
            SCROLL_VERTICAL,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(content)

    fun AppBox(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppLayout.() -> Unit
    ) =
        AppLayout(
            id,
            BOX,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(content)

    fun AppColumn(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppLayout.() -> Unit
    ) =
        AppLayout(
            id,
            VERTICAL,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(content)
}