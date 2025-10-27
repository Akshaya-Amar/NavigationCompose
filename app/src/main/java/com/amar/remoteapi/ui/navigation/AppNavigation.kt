package com.amar.remoteapi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.amar.remoteapi.ui.HomeDestination

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
      val backStack = rememberNavBackStack(HomeDestination)

      NavDisplay(
            modifier = modifier,
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                  homeNavGraph(backStack)
                  dashboardNavGraph(backStack)
                  settingNavGraph(backStack)
                  profileNavGraph(backStack)
                  postNavGraph(backStack)
                  notificationNavGraph(backStack)
            }
      )
}