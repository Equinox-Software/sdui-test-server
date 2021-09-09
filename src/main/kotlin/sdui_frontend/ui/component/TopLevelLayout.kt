package sdui_frontend.ui.component

import sdui_frontend.ui.action.*
import sdui_frontend.ui.style.*
import sdui_frontend.ui.type.ComponentType.*

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

    fun AppLazyRow(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        children: AppComponent.() -> Unit
    ) =
        AppComponent(
            id,
            SCROLL_HORIZONTAL,
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

    fun AppRow(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        children: AppComponent.() -> Unit
    ) =
        AppComponent(
            id,
            HORIZONTAL,
            action?.let { CAction().apply(it) },
            style?.let { CStyle().apply(it) }).apply(children)
}