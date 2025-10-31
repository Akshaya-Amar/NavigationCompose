package com.amar.remoteapi.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.amar.remoteapi.common.network.ApiResult
import com.amar.remoteapi.data.model.DemoData
import com.amar.remoteapi.data.model.Post
import com.amar.remoteapi.ui.component.ErrorView
import com.amar.remoteapi.ui.component.LoadingView
import com.amar.remoteapi.ui.viewmodel.PostViewModel

@Composable
fun ProfileScreen(
      viewModel: PostViewModel = hiltViewModel(),
) {
      LaunchedEffect(Unit) {
            viewModel.getDemoData()
      }

      val postResult by viewModel.demoResult.collectAsStateWithLifecycle()
      when (postResult) {
            is ApiResult.Idle -> {}
            is ApiResult.Loading -> {
                  Log.d("check...", "PostScreen: Loading")
                  LoadingView()
            }

            is ApiResult.Failure -> {
                  val message = (postResult as ApiResult.Failure).message
                  Log.d("check...", "PostScreen: $message")
                  ErrorView(message = message, onRetry = { viewModel.getDemoData() })
            }

            is ApiResult.Success -> {
                  val data = (postResult as ApiResult.Success<List<DemoData>>).data
                  Log.d("check...", "PostScreen: $data")
                  Log.d("check...", "PostScreen: ${data[0].title}")
                  Log.d("check...", "PostScreen: ${data[0].title::class.simpleName}")
            }
      }
}