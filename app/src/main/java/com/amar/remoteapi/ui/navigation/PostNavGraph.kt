package com.amar.remoteapi.ui.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.amar.remoteapi.ui.PostDestination
import com.amar.remoteapi.ui.screen.PostDetailScreen
import com.amar.remoteapi.ui.screen.PostScreen

fun EntryProviderScope<NavKey>.postNavGraph(backStack: MutableList<NavKey>) {
      entry<PostDestination.Root> {
            PostScreen(onPostClicked = {
                  backStack.add(PostDestination.Detail(it))
            })
      }

      entry<PostDestination.Detail> { key ->
            PostDetailScreen(key.post)
      }
}