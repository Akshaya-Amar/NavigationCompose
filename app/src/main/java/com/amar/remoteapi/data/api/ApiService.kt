package com.amar.remoteapi.data.api

import com.amar.remoteapi.data.model.DemoData
import com.amar.remoteapi.data.model.FileUploadResponse
import com.amar.remoteapi.data.model.Post

interface ApiService {
      suspend fun getPosts(): List<Post>

      suspend fun getDemoData(): List<DemoData>

      suspend fun uploadFile(
            bytes: ByteArray,
            mimeType: String,
            fileName: String
      ): FileUploadResponse
}