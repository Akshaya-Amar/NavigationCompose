package com.amar.remoteapi.data.serializer

import com.amar.remoteapi.common.Defaults
import com.amar.remoteapi.util.extensions.asFlexibleInt
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonPrimitive

object CustomIntSerializable : KSerializer<Int> {
      override val descriptor: SerialDescriptor =
            PrimitiveSerialDescriptor("FlexibleInt", PrimitiveKind.INT)

      override fun serialize(encoder: Encoder, value: Int) {
            encoder.encodeInt(value)
      }

      override fun deserialize(decoder: Decoder): Int {
            val input = decoder as? JsonDecoder
                  ?: error("FlexibleIntSerializer can be used only with JSON")
            val element = input.decodeJsonElement()

            return when (element) {
                  is JsonNull -> Defaults.INT_VALUE
                  is JsonPrimitive -> element.asFlexibleInt()
                  else -> Defaults.INT_VALUE
            }
      }
}
