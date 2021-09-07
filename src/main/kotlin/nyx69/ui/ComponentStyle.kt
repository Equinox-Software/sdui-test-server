package nyx69.ui

import io.ktor.util.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement

@Suppress("FunctionName")
object Style {
    fun CPadding(all: Int) = CPadding(all, all, all, all)
    fun CPadding(vertical: Int, horizontal: Int) = CPadding(vertical, horizontal, vertical, horizontal)
    fun CPadding(start: Int, top: Int, end: Int, bottom: Int) =
        Pair(ComponentStyleType.PADDING, Json.encodeToJsonElement(listOf(start, top, end, bottom)))

    fun CColor(color: Long)= Pair(ComponentStyleType.COLOR, Json.encodeToJsonElement(color))



}

fun sstyle(styles: (CStyle.() -> Unit)): CStyle {
return CStyle().apply(styles)


//    val encodedStyles = emptyMap<ComponentStyleType, JsonElement>().toMutableMap()



   // encodedStyles.putAll(styles)
//   return encodedStyles
}

/*
inline var Style.cccolor:  Pair<ComponentStyleType, JsonElement>
    @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
    set(color: Long) =CColor(color)


inline var Style.chhcolor: Long
    @Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter
    set(color: Long) =CColor(color)

 */










@Serializable
data class CStyle(
    @InternalAPI var padding:List<Int>? = null,
    var color:Long?=null
)

@OptIn(InternalAPI::class)
fun CStyle.setP(all: Int){
    padding=listOf(all)
}

fun CStyle.setC(colorrr:Long){
    color=colorrr
}





@PublishedApi
internal const val NO_GETTER = "Property does not have a getter"
@PublishedApi
internal inline val noGetter: Nothing
    get() = throw UnsupportedOperationException(NO_GETTER)