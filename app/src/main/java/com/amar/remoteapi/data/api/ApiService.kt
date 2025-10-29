package com.amar.remoteapi.data.api

import com.amar.remoteapi.data.model.FileUploadResponse
import com.amar.remoteapi.data.model.Post

interface ApiService {
      suspend fun getPosts(): List<Post>

      suspend fun uploadFile(
            bytes: ByteArray,
            mimeType: String,
            fileName: String
      ): FileUploadResponse
}