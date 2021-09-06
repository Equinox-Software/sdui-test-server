package nyx69.ui

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = Any::class)
object AnySerializer : KSerializer<Any> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Any", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Any) {
        when (value) {
            is String -> encoder.encodeString(value)
            is Int -> encoder.encodeInt(value)
            is Boolean -> encoder.encodeBoolean(value)
            is Long -> encoder.encodeLong(value)
            else -> encoder.encodeString("No value found")
        }
    }

 //   override fun deserialize(decoder: Decoder): Any {
    //   decoder.decodeString()
      /*  return when {
            is String -> decoder.decodeString()
            is Int -> Json.encodeToJsonElement(value)
            is Boolean -> Json.encodeToJsonElement(value)
            is Long -> Json.encodeToJsonElement(value)
            else -> Json.encodeToJsonElement("No value found")
        }
         decoder.decodeString()) */

  //  }
}