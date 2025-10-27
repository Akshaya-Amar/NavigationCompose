package com.amar.remoteapi.ui

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface SettingDestination : NavKey {
      @Serializable object Root : SettingDestination
      @Serializable object Account : SettingDestination
      @Serializable object Notifications : SettingDestination
      @Serializable object Privacy : SettingDestination
      @Serializable object Security : SettingDestination
      @Serializable object Language : SettingDestination
      @Serializable object Themes : SettingDestination
      @Serializable object About : SettingDestination
      @Serializable object Help : SettingDestination
      @Serializable data class EditAccount(val userId: String) : SettingDestination
      @Serializable data class ChangePassword(val userId: String) : SettingDestination
      @Serializable object LinkedAccounts : SettingDestination
      @Serializable object Billing : SettingDestination
      @Serializable object Subscriptions : SettingDestination
      @Serializable object Feedback : SettingDestination
      @Serializable object Terms : SettingDestination
      @Serializable object PrivacyPolicy : SettingDestination
      @Serializable object NotificationsDetail : SettingDestination
      @Serializable object Experimental : SettingDestination
      @Serializable object BackupRestore : SettingDestination
}
