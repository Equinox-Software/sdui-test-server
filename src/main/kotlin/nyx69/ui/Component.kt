package nyx69.ui

import io.ktor.util.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
import nyx69.ui.ComponentType.*

@Suppress("FunctionName")
@Serializable
data class Component(
    val id: String,
    val type: ComponentType,
    val data: JsonElement? = null,
    var children: MutableList<Component>? = null,
    val action: CAction? = null,
    var style: CStyle? = null
) {
    fun CEditText(id: String, text: String, style: (CStyle.() -> Unit)? = null) =
        this.children?.add(Widget.CEditText(id, text, style))

    fun CImage(id: String, url: String, style: (CStyle.() -> Unit)? = null) =
        this.children?.add(Widget.CImage(id, url, style))

    fun CButton(id: String, text: String, style: (CStyle.() -> Unit)? = null, action: CAction.() -> Unit) =
        this.children?.add(Widget.CButton(id, text, style, action))


    fun CLazyColumn(id: String, style: (CStyle.() -> Unit)? = null, content: Component.() -> Unit) =
        this.children?.add(Layout.CLazyColumn(id, style, content))

    //   fun CBox(id: String, style: (CStyle.() -> Unit)? = null, content: Component.() -> Unit) =
    //     this.children?.add(Layout.CBox(id, style, content))

    fun CColumn(id: String, style: (CStyle.() -> Unit)? = null, content: Component.() -> Unit) =
        this.children?.add(Layout.CColumn(id, style, content))
}

@Suppress("FunctionName")
object Widget {
    //   fun CText(id: String, text: String, style: (CStyle.() -> Unit)? = null) =
    //     Component(id, TEXT, Json.encodeToJsonElement(text), style = style?.let { CStyle().apply(it) })

    fun CEditText(id: String, text: String, style: (CStyle.() -> Unit)? = null) =
        Component(id, EDIT_TEXT, Json.encodeToJsonElement(text), style = style?.let { CStyle().apply(it) })

    fun CImage(id: String, url: String, style: (CStyle.() -> Unit)? = null) =
        Component(id, IMAGE, Json.encodeToJsonElement(url), style = style?.let { CStyle().apply(it) })

    fun CButton(id: String, text: String, style: (CStyle.() -> Unit)? = null, action: CAction.() -> Unit) = Component(
        id,
        BUTTON,
        Json.encodeToJsonElement(text),
        action = CAction().apply(action),
        style = style?.let { CStyle().apply(it) })
}

@Suppress("FunctionName")
object Layout {
    fun CLazyColumn(id: String, style: (CStyle.() -> Unit)? = null, content: Component.() -> Unit) =
        Component(id, SCROLL_VERTICAL, style = style?.let { CStyle().apply(it) }, children = mutableListOf()).apply(
            content
        )

//    fun CBox(id: String, style: (CStyle.() -> Unit)? = null, content: Component.() -> Unit) =
    //      Component(id, BOX, style = style?.let { CStyle().apply(it) }, children = mutableListOf()).apply(content)

    fun CColumn(id: String, style: (CStyle.() -> Unit)? = null, content: Component.() -> Unit) =
        Component(id, VERTICAL, style = style?.let { CStyle().apply(it) }, children = mutableListOf()).apply(content)
}

//maybe let Layout/Widget extend Component and just pass own classes for any of that

// prettier?

fun Component?.CText(id: String, text: String, style: (CStyle.() -> Unit)? = null) =
    this?.children?.add(
        Component(
            id,
            TEXT,
            Json.encodeToJsonElement(text),
            style = style?.let { CStyle().apply(it) })
    ) ?: Component(id, TEXT, Json.encodeToJsonElement(text), style = style?.let { CStyle().apply(it) })

/*
fun Component?.CBox(id: String, style: (CStyle.() -> Unit)? = null, content: Component.() -> Unit) =
    this?.children?.add(
        Component(id, VERTICAL, style = style?.let { CStyle().apply(it) }, children = mutableListOf()).apply(content)
    ) ?: Component(id, VERTICAL, style = style?.let { CStyle().apply(it) }, children = mutableListOf()).apply(content)
*/

@Serializable
sealed class AppComponent(
    val id: String,
    val type: ComponentType,
    val action: CAction? = null,
    val style: CStyle? = null
) {
    open class AppLayout(
        id: String,
        type: ComponentType,
        action: CAction? = null,
        style: CStyle? = null,
        children: MutableList<Component>=mutableListOf()):AppComponent(id,type,action,style)
}

@DslMarker
annotation class CLayoutDSL


interface CComponent {
    val id: String
    val action: (CAction.() -> Unit)?
    val style: (CStyle.() -> Unit)?
}

interface CLayout : CComponent {
    val content: Component.() -> Unit
}

interface CWidget : CComponent {
    val data: JsonElement
}

@CLayoutDSL
class BoxxBuilder : CLayout {

    private var component= Component(id,BOX)

    override var action: (CAction.() -> Unit)? = null
    override var style: (CStyle.() -> Unit)? = null
    override lateinit var content: (Component.() -> Unit)

    fun build():Component = component
}

fun CBox(id: String, stylee: (StyleBuilder.() -> Unit)? = null, content: Component.() -> Unit): Component  {

    val component = Component(id,BOX)


        stylee?.let {
            val builder = StyleBuilder()
            builder.stylee()
            return@let builder.build()
        }

    return component
}



@CLayoutDSL
class StyleBuilder {

    private var style= CStyle()

    @OptIn(InternalAPI::class)
    fun padding(all: Int) {
       style. padding = listOf(all, all, all, all)
    }

    @OptIn(InternalAPI::class)
    fun padding(vertical: Int, horizontal: Int) {
        style.padding = listOf(vertical, horizontal, vertical, horizontal)
    }

    @OptIn(InternalAPI::class)
    fun padding(start: Int, top: Int, end: Int, bottom: Int) {
        style.padding = listOf(start, top, end, bottom)
    }

    var color:Long? = null

   fun build():CStyle = style
}

