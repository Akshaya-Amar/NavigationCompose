package com.amar.remoteapi.ui

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface NotificationDestination: NavKey {
      @Serializable object Root: NotificationDestination
      @Serializable object Alerts: NotificationDestination
      @Serializable object Messages: NotificationDestination
}