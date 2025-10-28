package com.amar.remoteapi.ui.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.amar.remoteapi.ui.BillingDestination
import com.amar.remoteapi.ui.SettingDestination
import com.amar.remoteapi.ui.screen.AboutScreen
import com.amar.remoteapi.ui.screen.AccountScreen
import com.amar.remoteapi.ui.screen.HelpScreen
import com.amar.remoteapi.ui.screen.SettingsScreen
import com.amar.remoteapi.ui.screen.TermsScreen

fun EntryProviderScope<NavKey>.settingNavGraph(backStack: MutableList<NavKey>) {
      entry<SettingDestination.Root> {
            SettingsScreen(
                  onAccountClick = { backStack.add(SettingDestination.Account) },
                  onHelpClick = { backStack.add(SettingDestination.Help) },
                  onAboutClick = { backStack.add(SettingDestination.About) },
                  onTermsClick = { backStack.add(SettingDestination.Terms) },
                  onBillingClick = { backStack.add(BillingDestination.Root) }
            )
      }

      entry<SettingDestination.Account> {
            AccountScreen()
      }

      entry<SettingDestination.Help> {
            HelpScreen()
      }

      entry<SettingDestination.About> {
            AboutScreen()
      }

      entry<SettingDestination.Terms> {
            TermsScreen()
      }

      billingNavGraph(backStack)
}