package nyx69.ui.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ComponentType {
    @SerialName("0")
    SCROLL_VERTICAL,
    @SerialName("1")
    BOX,
    @SerialName("2")
    VERTICAL,
    @SerialName("3")
    SELECTABLE_LIST,
    @SerialName("4")
    SELECTABLE_ROW,
    @SerialName("5")
    TEXT,
    @SerialName("6")
    BUTTON,
    @SerialName("7")
    IMAGE,
    @SerialName("8")
    EDIT_TEXT,
    @SerialName("9")
    DIVIDER
}