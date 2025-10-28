package com.amar.remoteapi.ui.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.amar.remoteapi.ui.ProfileDestination
import com.amar.remoteapi.ui.screen.ProfileScreen

fun EntryProviderScope<NavKey>.profileNavGraph(backStack: MutableList<NavKey>) {
      entry<ProfileDestination.Root> {
            ProfileScreen()
      }
}