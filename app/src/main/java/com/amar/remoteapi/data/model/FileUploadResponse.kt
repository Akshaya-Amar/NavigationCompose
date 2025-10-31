package com.amar.remoteapi.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileUploadResponse(
      val res: Int = 0,
      @SerialName("msg") val message: String = "",
      @SerialName("image_url") val imageUrl: String = ""
)