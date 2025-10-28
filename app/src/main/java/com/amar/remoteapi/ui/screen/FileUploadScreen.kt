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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.math.log

@Composable
fun FileUploadScreen() {
      val context = LocalContext.current
       val imagePickerLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
      ) { uri ->
            uri?.let {
                  Log.d("check...", "FileUploadScreen: Image -> $it")
//                  val file = uriToFile(context, it)
//                  viewModel.uploadFile(file, "My Image Note", "image")
            }
      }

      val videoPickerLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
      ) { uri ->
            uri?.let {
                  Log.d("check...", "FileUploadScreen: Video -> $it")
//                  val file = uriToFile(context, it)
//                  viewModel.uploadFile(file, "My Video Note", "video")
            }
      }

      val pdfPickerLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
      ) { uri ->
            uri?.let {
                  Log.d("check...", "FileUploadScreen: PDF -> $it")
//                  val file = uriToFile(context, it)
//                  viewModel.uploadFile(file, "My PDF Note", "pdf")
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
