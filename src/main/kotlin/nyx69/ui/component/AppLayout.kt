package nyx69.ui.component

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import nyx69.ui.ComponentSerializer
import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType

@Suppress("FunctionName")
@Serializable(ComponentSerializer::class)
data class AppLayout(
    override val id: String,
    override val type: ComponentType,
    override val action: CAction? = null,
    override val style: CStyle? = null,
    private val children: MutableList<@Contextual AppComponent> = mutableListOf()
) : AppComponent {

    fun AppText(
        id: String, text: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null
    ) = this.children.add(TopLevelWidget.AppText(id, text, action, style))

    fun AppEditText(
        id: String, text: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null
    ) = this.children.add(TopLevelWidget.AppEditText(id, text, action, style))

    fun AppImage(
        id: String, url: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null
    ) = this.children.add(TopLevelWidget.AppImage(id, url, action, style))

    fun AppButton(
        id: String, text: String,
        style: (CStyle.() -> Unit)? = null,
        action: (CAction.() -> Unit),
    ) = this.children.add(TopLevelWidget.AppButton(id, text, style, action))

    fun AppLazyColumn(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppComponent.() -> Unit
    ) = this.children.add(TopLevelLayout.AppLazyColumn(id, action, style, content))

    fun AppBox(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppComponent.() -> Unit
    ) = this.children.add(TopLevelLayout.AppBox(id, action, style, content))

    fun AppColumn(
        id: String,
        action: (CAction.() -> Unit)? = null,
        style: (CStyle.() -> Unit)? = null,
        content: AppComponent.() -> Unit
    ) = this.children.add(TopLevelLayout.AppColumn(id, action, style, content))

    fun AppDivider(
        id: String, style: (CStyle.() -> Unit)? = null
    ) = this.children.add(TopLevelGeneric.AppDivider(id, style))
}