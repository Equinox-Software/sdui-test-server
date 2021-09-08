package nyx69.ui.component

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType
import nyx69.ui.type.LayoutType

@Serializable
sealed class AppComponent(
    val id: String,
    val type: ComponentType,
    val action: CAction?=null,
    val style: CStyle?=null
)