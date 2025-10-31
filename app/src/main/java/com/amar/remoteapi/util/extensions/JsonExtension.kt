package com.amar.remoteapi.util.extensions

import com.amar.remoteapi.common.Defaults
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.double
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.float
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.long
import kotlinx.serialization.json.longOrNull

val JsonPrimitive.isBoolean: Boolean get() = booleanOrNull != null
val JsonPrimitive.isInt: Boolean get() = intOrNull != null
val JsonPrimitive.isLong: Boolean get() = longOrNull != null
val JsonPrimitive.isFloat: Boolean get() = floatOrNull != null
val JsonPrimitive.isDouble: Boolean get() = doubleOrNull != null

fun JsonPrimitive.asFlexibleString(): String = when {
      isString -> content
      isBoolean -> boolean.toString()
      isInt -> int.toString()
      isLong -> long.toString()
      isFloat -> float.toString()
      isDouble -> double.toString()
      else -> toString()
}

fun JsonPrimitive.asFlexibleInt(): Int = when {
      isInt -> int
      isString -> content.toIntOrNull() ?: Defaults.INT_VALUE
      isLong -> long.toInt()
      isDouble -> double.toInt()
      isBoolean -> if (boolean) 1 else Defaults.INT_VALUE
      else -> Defaults.INT_VALUE
}