package com.amar.remoteapi.ui.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.amar.remoteapi.ui.FileUploadDestination
import com.amar.remoteapi.ui.screen.FileUploadScreen

fun EntryProviderScope<NavKey>.fileUploadNavGraph(backStack: MutableList<NavKey>) {
      entry<FileUploadDestination.Root> {
            FileUploadScreen()
      }
}