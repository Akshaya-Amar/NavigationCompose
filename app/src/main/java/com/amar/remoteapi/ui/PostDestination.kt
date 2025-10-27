package com.amar.remoteapi.ui

import androidx.navigation3.runtime.NavKey
import com.amar.remoteapi.data.model.Post
import kotlinx.serialization.Serializable
@Serializable
sealed interface PostDestination : NavKey {
      @Serializable object Root : PostDestination
      @Serializable data class Detail(val post: Post) : PostDestination
      @Serializable object Create : PostDestination
      @Serializable object Drafts : PostDestination
      @Serializable object Favorites : PostDestination
}
