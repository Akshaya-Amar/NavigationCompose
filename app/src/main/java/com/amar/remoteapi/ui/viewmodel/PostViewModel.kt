package com.amar.remoteapi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amar.remoteapi.common.network.ApiResult
import com.amar.remoteapi.data.model.DemoData
import com.amar.remoteapi.data.model.FileUploadResponse
import com.amar.remoteapi.data.model.Post
import com.amar.remoteapi.data.repository.PostRepository
import com.amar.remoteapi.util.FileUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
      private val repository: PostRepository
) : ViewModel() {
      private var _posts = MutableStateFlow<ApiResult<List<Post>>>(ApiResult.Idle)
      val posts = _posts.asStateFlow()

      private var _demoResult = MutableStateFlow<ApiResult<List<DemoData>>>(ApiResult.Idle)
      val demoResult = _demoResult.asStateFlow()

      private var _fileUploadResult = MutableStateFlow<ApiResult<FileUploadResponse>>(ApiResult.Idle)
      val fileUploadResult = _fileUploadResult.asStateFlow()

      fun getPosts() {
            viewModelScope.launch {
                  _posts.value = ApiResult.Loading
                  repository.getPosts().collectLatest {
                        _posts.value = it
                  }
            }
      }

      fun getDemoData() {
            viewModelScope.launch {
                  _demoResult.value = ApiResult.Loading
                  repository.getDemoData().collectLatest {
                        _demoResult.value = it
                  }
            }
      }

      fun uploadFile(
            bytes: ByteArray?,
            mimeType: String
      ) {
            if (bytes == null) {
                  _fileUploadResult.value = ApiResult.Failure("Failed to read file")
                  return
            }

            val fileName = FileUtils.getFileName(mimeType)

            viewModelScope.launch {
                  _fileUploadResult.value = ApiResult.Loading
                  repository.uploadFile(
                        bytes,
                        mimeType,
                        fileName
                  ).collectLatest {
                        _fileUploadResult.value = it
                  }
            }
      }
}