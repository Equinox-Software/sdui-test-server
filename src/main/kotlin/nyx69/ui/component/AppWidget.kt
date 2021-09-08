package nyx69.ui.component

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType

@Suppress("FunctionName")
class AppWidget(
    id: String,
    type: ComponentType,
    action: CAction? = null,
    style: CStyle? = null,
    private val data: JsonElement,
) : AppComponent(id,type,action,style)
