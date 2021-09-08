package nyx69.ui

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import nyx69.ui.component.AppComponent
import nyx69.ui.component.AppGeneric
import nyx69.ui.component.AppLayout
import nyx69.ui.component.AppWidget

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = AppComponent::class)
object ComponentSerializer : KSerializer<AppComponent> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Any", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: AppComponent) {
        when (value) {
            is AppLayout -> Json.encodeToJsonElement(value)
            is AppWidget -> Json.encodeToJsonElement(value)
            is AppGeneric -> Json.encodeToJsonElement(value)
            else -> throw SerializationException("Unsupported Type! Can't serialize $value.")
        }
    }

    override fun deserialize(decoder: Decoder): AppComponent {
        TODO("Not yet implemented")
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