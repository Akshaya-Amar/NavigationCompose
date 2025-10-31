package com.amar.remoteapi.data.model

import com.amar.remoteapi.data.serializer.CustomStringSerializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post(
      @SerialName("userId") val userId: Int,
      @SerialName("id") val id: Int,
      @Serializable(with = CustomStringSerializable::class)
      @SerialName("title") val title: String,
      @SerialName("body") val body: String
)