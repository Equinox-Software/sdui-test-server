package nyx69.ui.component

import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.LayoutType

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
            LayoutType.SCROLL_VERTICAL,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(content)

    fun AppBox(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppLayout.() -> Unit
    ) =
        AppLayout(id, LayoutType.BOX, action?.let { CAction().apply(it) }, style?.let { CStyle().apply(it) }).apply(
            content
        )

    fun AppColumn(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppLayout.() -> Unit
    ) =
        AppLayout(
            id,
            LayoutType.VERTICAL,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(content)
}