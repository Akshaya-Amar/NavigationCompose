package com.amar.remoteapi.data.repository

import com.amar.remoteapi.common.network.ApiResult
import com.amar.remoteapi.data.model.DemoData
import com.amar.remoteapi.data.model.FileUploadResponse
import com.amar.remoteapi.data.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
      suspend fun getPosts(): Flow<ApiResult<List<Post>>>

      suspend fun getDemoData(): Flow<ApiResult<List<DemoData>>>

      suspend fun uploadFile(
            bytes: ByteArray,
            mimeType: String,
            fileName: String
      ): Flow<ApiResult<FileUploadResponse>>
}