package nyx69.ui.component

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType.*

@Suppress("FunctionName")
object TopLevelWidget {
    fun AppText(id: String, text: String, action: (CAction.() -> Unit)? = null, style: (CStyle.() -> Unit)? = null) =
        AppComponent(
            id,
            TEXT,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) },
            Json.encodeToJsonElement(text)
        )

    fun AppEditText(
        id: String,
        text: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null
    ) =
        AppComponent(
            id,
            EDIT_TEXT,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) },
            Json.encodeToJsonElement(text)
        )

    fun AppImage(id: String, url: String, action: (CAction.() -> Unit)? = null, style: (CStyle.() -> Unit)? = null) =
        AppComponent(
            id,
            IMAGE,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) },
            Json.encodeToJsonElement(url)
        )

    fun AppButton(id: String, text: String, style: (CStyle.() -> Unit)? = null, action: (CAction.() -> Unit)) =
        AppComponent(
            id,
            BUTTON,
            CAction().apply(action),
            style?.let { CStyle().apply(it) },
            Json.encodeToJsonElement(text)
        )
}
