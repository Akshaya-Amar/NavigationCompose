package com.amar.remoteapi.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.amar.remoteapi.ui.HomeDestination

@Composable
fun AppNavigation(
      modifier: Modifier = Modifier,
      destination: NavKey = HomeDestination.Root
) {
      val backStack = rememberNavBackStack(destination)

      LaunchedEffect(backStack.size) {
            backStack.forEach { key ->
                  Log.d("check...", "${key::class.qualifiedName}")
            }
      }

      NavDisplay(
            modifier = modifier,
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() }, // can write custom logic on back pressed, or if backstack size is 1
            entryProvider = entryProvider {
                  homeNavGraph(backStack)
            }
      )
}