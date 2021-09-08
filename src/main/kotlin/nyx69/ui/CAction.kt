package nyx69.ui

import kotlinx.serialization.Serializable

@Serializable
data class CAction(
    var click: String? = null,
    var navigate: String? = null,
    var select: String? = null
) {
    fun CAction.click(destination: String) {
        click = destination
    }

    fun CAction.select(destination: String) {
        select = destination
    }
}

fun action(actions: CAction.() -> Unit) = CAction().apply(actions)