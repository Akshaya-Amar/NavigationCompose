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

fun EntryProviderScope<NavKey>.settingNavGraph(backstack: MutableList<NavKey>) {
      entry<SettingDestination.Root> {
            SettingsScreen(
                  onAccountClick = { backstack.add(SettingDestination.Account) },
                  onHelpClick = { backstack.add(SettingDestination.Help) },
                  onAboutClick = { backstack.add(SettingDestination.About) },
                  onTermsClick = { backstack.add(SettingDestination.Terms) },
                  onBillingClick = { backstack.add(BillingDestination.Root) }
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

      billingNavGraph(backstack)
}