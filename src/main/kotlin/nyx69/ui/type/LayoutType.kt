package nyx69.ui.type

import kotlinx.serialization.Serializable

enum class LayoutType : ComponentType {
    SCROLL_VERTICAL,
    BOX,
    VERTICAL,
    SELECTABLE_LIST,
    SELECTABLE_ROW,
}