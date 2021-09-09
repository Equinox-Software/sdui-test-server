package sdui_frontend.ui.component

import kotlinx.serialization.json.*
import sdui_frontend.ui.action.*
import sdui_frontend.ui.style.*
import sdui_frontend.ui.type.ComponentType.*

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
