package com.amar.remoteapi.ui

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface DashboardDestination : NavKey {
      @Serializable object Root : DashboardDestination
      @Serializable object Overview : DashboardDestination
      @Serializable object Analytics : DashboardDestination
      @Serializable object Reports : DashboardDestination
      @Serializable object QuickActions : DashboardDestination
}