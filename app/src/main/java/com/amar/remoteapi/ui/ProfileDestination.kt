package com.amar.remoteapi.ui

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface ProfileDestination : NavKey {
      @Serializable object Root : ProfileDestination
      @Serializable object Overview : ProfileDestination
      @Serializable object EditProfile : ProfileDestination
      @Serializable object FriendsList : ProfileDestination
      @Serializable data class FriendDetail(val friendId: String) : ProfileDestination
      @Serializable object Posts : ProfileDestination
      @Serializable object Photos : ProfileDestination
      @Serializable object Videos : ProfileDestination
      @Serializable object Privacy : ProfileDestination
      @Serializable object Achievements : ProfileDestination
      @Serializable object Badges : ProfileDestination
      @Serializable object ActivityLog : ProfileDestination
      @Serializable object Notifications : ProfileDestination
      @Serializable object LogoutConfirm : ProfileDestination
}
