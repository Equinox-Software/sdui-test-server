package nyx69.ui.component

import kotlinx.serialization.Serializable
import nyx69.ui.action.CAction
import nyx69.ui.style.CStyle
import nyx69.ui.type.ComponentType


@Suppress("FunctionName")
@Serializable
data class AppGeneric(
    override val id: String,
    override val type: ComponentType,
    override val action: CAction? = null,
    override val style: CStyle? = null,
) : AppComponent


