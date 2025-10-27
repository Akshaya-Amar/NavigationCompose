package com.amar.remoteapi.ui.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.amar.remoteapi.ui.DashboardDestination
import com.amar.remoteapi.ui.HomeDestination
import com.amar.remoteapi.ui.NotificationDestination
import com.amar.remoteapi.ui.PostDestination
import com.amar.remoteapi.ui.ProfileDestination
import com.amar.remoteapi.ui.SettingDestination
import com.amar.remoteapi.ui.screen.HomeScreen

fun EntryProviderScope<NavKey>.homeNavGraph(backStack: MutableList<NavKey>) {
      entry<HomeDestination> {
            HomeScreen(
                  onDashboardClick = { backStack.add(DashboardDestination.Root) },
                  onSettingsClick = { backStack.add(SettingDestination.Root) },
                  onProfileClick = { backStack.add(ProfileDestination.Root) },
                  onPostClick = { backStack.add((PostDestination.Root)) },
                  onNotificationClick = { backStack.add(NotificationDestination.Root) }
            )
      }
}