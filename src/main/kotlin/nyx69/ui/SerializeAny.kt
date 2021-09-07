package nyx69.ui

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
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
            is List<*> -> encoder.encodeSerializableValue(
                ListSerializer(AnySerializer), value as List<@kotlinx.serialization.Serializable(
                    nyx69.ui.AnySerializer::class
                ) Any>
            )
            else -> throw SerializationException("Unsupported Type! Can't serialize $value.")
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