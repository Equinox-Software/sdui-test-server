package sdui_frontend.ui.action

import kotlinx.serialization.*

@Serializable
data class CAction(
    var click: String? = null,
    var navigate: String? = null,
    var select: String? = null,
    var keys: List<String>?=null
) {
    fun CAction.click(destination: String) {
        click = destination
    }

    fun CAction.select(destination: String) {
        select = destination
    }
}