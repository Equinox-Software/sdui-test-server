package nyx69.ui.component

import kotlinx.serialization.json.JsonElement
import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType

interface AppComponent{
    val id: String
    val type: JsonElement
    val action: CAction?
    val style: CStyle?
}