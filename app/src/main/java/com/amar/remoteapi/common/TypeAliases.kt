package com.amar.remoteapi.common

import com.amar.remoteapi.data.serializer.CustomStringSerializable
import kotlinx.serialization.Serializable

typealias FlexString = @Serializable(with = CustomStringSerializable::class) String