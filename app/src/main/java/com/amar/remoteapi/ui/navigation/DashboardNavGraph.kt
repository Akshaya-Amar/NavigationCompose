package com.amar.remoteapi.ui.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.amar.remoteapi.ui.DashboardDestination
import com.amar.remoteapi.ui.screen.AnalyticsScreen
import com.amar.remoteapi.ui.screen.DashboardScreen
import com.amar.remoteapi.ui.screen.OverviewScreen
import com.amar.remoteapi.ui.screen.QuickActionScreen
import com.amar.remoteapi.ui.screen.ReportScreen

fun EntryProviderScope<NavKey>.dashboardNavGraph(backStack: MutableList<NavKey>) {
      entry<DashboardDestination.Root> {
            DashboardScreen(
                  onReportClicked = { backStack.add(DashboardDestination.Reports) },
                  onAnalyticClicked = { backStack.add(DashboardDestination.Analytics) },
                  onOverviewClicked = { backStack.add(DashboardDestination.Overview) },
                  onQuickActionClicked = { backStack.add(DashboardDestination.QuickActions) }
            )
      }

      entry<DashboardDestination.Overview> {
            OverviewScreen()
      }

      entry<DashboardDestination.Analytics> {
            AnalyticsScreen()
      }

      entry<DashboardDestination.Reports> {
            ReportScreen()
      }

      entry<DashboardDestination.QuickActions> {
            QuickActionScreen()
      }
}