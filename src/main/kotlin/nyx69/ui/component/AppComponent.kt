package nyx69.ui.component

import kotlinx.serialization.Serializable
import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType

sealed interface AppComponent {
    val id: String
    val type: ComponentType
    val action: CAction?
    var style: CStyle?
}