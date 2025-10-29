package com.amar.remoteapi.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileUploadResponse(
      @SerialName("res") val res: Int,
      @SerialName("msg") val message: String,
      @SerialName("image_url") val imageUrl: String? = null
)