package com.amar.remoteapi.ui.screen

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.amar.remoteapi.common.network.ApiResult
import com.amar.remoteapi.data.model.FileUploadResponse
import com.amar.remoteapi.ui.component.LoadingView
import com.amar.remoteapi.ui.viewmodel.PostViewModel
import com.amar.remoteapi.util.FileUtils

@Composable
fun FileUploadScreen(
      viewModel: PostViewModel = hiltViewModel()
) {
      val uploadResult by viewModel.fileUploadResult.collectAsStateWithLifecycle()
      when (uploadResult) {
            is ApiResult.Idle -> {}
            is ApiResult.Loading -> {
                  LoadingView()
                  Log.d("check...", "FileUploadScreen: Loading")
            }

            is ApiResult.Failure -> {
                  val message = (uploadResult as ApiResult.Failure).message
                  Log.d("check...", "FileUploadScreen: Failure -> $message")
            }

            is ApiResult.Success -> {
                  val uploadResponse = (uploadResult as ApiResult.Success<FileUploadResponse>).data
                  Log.d("check...", "FileUploadScreen: Success -> $uploadResponse")
            }
      }

      val context = LocalContext.current
      val imagePickerLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
      ) { uri ->
            uri?.let { selectedUri ->
                  val byteArray = FileUtils.getBytesFromUri(context, selectedUri)
                  val mimeType = FileUtils.getMimeType(context, selectedUri)
                  Log.d("check...", "Image URI -> $selectedUri, Image filetype -> $mimeType")
                  viewModel.uploadFile(
                        bytes = byteArray,
                        mimeType = mimeType
                  )
            }
      }

      val videoPickerLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
      ) { uri ->
            uri?.let { selectedUri ->
                  val byteArray = FileUtils.getBytesFromUri(context, selectedUri)
                  val mimeType = FileUtils.getMimeType(context, selectedUri)
                  Log.d("check...", "Image URI -> $selectedUri, Video filetype -> $mimeType")
                  viewModel.uploadFile(
                        bytes = byteArray,
                        mimeType = mimeType
                  )
            }
      }

      val pdfPickerLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
      ) { uri ->
            uri?.let {selectedUri->
                  val byteArray = FileUtils.getBytesFromUri(context, selectedUri)
                  val mimeType = FileUtils.getMimeType(context, selectedUri)
                  Log.d("check...", "Image URI -> $selectedUri, Document filetype -> $mimeType")
                  viewModel.uploadFile(
                        bytes = byteArray,
                        mimeType = mimeType
                  )
            }
      }

      Column(
            modifier = Modifier
                  .fillMaxSize()
                  .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
      ) {
            Text(
                  text = "File Upload Screen",
                  style = MaterialTheme.typography.titleLarge
            )

            Button(onClick = { imagePickerLauncher.launch("image/*") }) {
                  Text("Upload Image")
            }

            Button(onClick = { videoPickerLauncher.launch("video/*") }) {
                  Text("Upload Video")
            }

            Button(onClick = { pdfPickerLauncher.launch("application/pdf") }) {
                  Text("Upload PDF")
            }
      }
}
