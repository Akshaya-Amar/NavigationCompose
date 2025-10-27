package com.amar.remoteapi.ui.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.amar.remoteapi.ui.NotificationDestination
import com.amar.remoteapi.ui.screen.NotificationScreen

fun EntryProviderScope<NavKey>.notificationNavGraph(backStack: MutableList<NavKey>) {
      entry<NotificationDestination.Root> {
            NotificationScreen()
      }
}