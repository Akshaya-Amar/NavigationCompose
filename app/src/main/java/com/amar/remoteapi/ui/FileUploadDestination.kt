package com.amar.remoteapi.ui

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface FileUploadDestination : NavKey {
      @Serializable object Root : FileUploadDestination
}