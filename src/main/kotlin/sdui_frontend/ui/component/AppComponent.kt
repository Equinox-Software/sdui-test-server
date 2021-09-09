package sdui_frontend.ui.component

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import sdui_frontend.ui.action.*
import sdui_frontend.ui.style.*
import sdui_frontend.ui.type.*

@Suppress("FunctionName")
@Serializable
class AppComponent(
    val id: String,
    val type: ComponentType,
    val action: CAction? = null,
    val style: CStyle? = null,
    val data: JsonElement? = null,
    val children: MutableList<@Contextual AppComponent>? = mutableListOf()
) {
    fun AppText(
        id: String, text: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null
    ) = this.children?.add(TopLevelWidget.AppText(id, text, action, style))

    fun AppEditText(
        id: String, text: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null
    ) = this.children?.add(TopLevelWidget.AppEditText(id, text, action, style))

    fun AppImage(
        id: String, url: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null
    ) = this.children?.add(TopLevelWidget.AppImage(id, url, action, style))

    fun AppButton(
        id: String, text: String,
        style: (CStyle.() -> Unit)? = null,
        action: (CAction.() -> Unit),
    ) = this.children?.add(TopLevelWidget.AppButton(id, text, style, action))

    fun AppLazyColumn(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppComponent.() -> Unit
    ) = this.children?.add(TopLevelLayout.AppLazyColumn(id, action, style, content))

    fun AppLazyRow(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppComponent.() -> Unit
    ) = this.children?.add(TopLevelLayout.AppLazyRow(id, action, style, content))

    fun AppBox(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppComponent.() -> Unit
    ) = this.children?.add(TopLevelLayout.AppBox(id, action, style, content))

    fun AppColumn(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppComponent.() -> Unit
    ) = this.children?.add(TopLevelLayout.AppColumn(id, action, style, content))

    fun AppRow(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppComponent.() -> Unit
    ) = this.children?.add(TopLevelLayout.AppRow(id, action, style, content))

    fun AppDivider(
        id: String, style: (CStyle.() -> Unit)? = null
    ) = this.children?.add(TopLevelGeneric.AppDivider(id, style))

}