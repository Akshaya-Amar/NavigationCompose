package com.amar.remoteapi.data.serializer

import com.amar.remoteapi.common.Defaults
import com.amar.remoteapi.util.extensions.asFlexibleString
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonPrimitive

object CustomStringSerializable : KSerializer<String> {
      override val descriptor: SerialDescriptor =
            PrimitiveSerialDescriptor("FlexibleString", PrimitiveKind.STRING)

      override fun serialize(encoder: Encoder, value: String) {
            encoder.encodeString(value)
      }

      override fun deserialize(decoder: Decoder): String {
            val input = decoder as? JsonDecoder ?: error("FlexibleStringSerializer can be used only with JSON")
            val element = input.decodeJsonElement()
            return when (element) {
                  is JsonNull -> Defaults.STRING_VALUE
                  is JsonPrimitive -> element.asFlexibleString()
                  else -> element.toString()
            }
      }
}