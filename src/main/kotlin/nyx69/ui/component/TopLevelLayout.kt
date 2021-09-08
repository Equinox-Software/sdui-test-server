package nyx69.ui.component

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.LayoutType.*

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
            Json.encodeToJsonElement(SCROLL_VERTICAL),
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
            Json.encodeToJsonElement(BOX),
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
            Json.encodeToJsonElement(VERTICAL),
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(content)
}