package com.amar.remoteapi.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
      modifier: Modifier = Modifier,
      onDashboardClick: () -> Unit,
      onSettingsClick: () -> Unit,
      onProfileClick: () -> Unit,
      onPostClick: () -> Unit,
      onNotificationClick: () -> Unit,
      onFileUploadClick: () -> Unit
) {
      Column(
            modifier = Modifier
                  .fillMaxSize()
                  .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
      ) {
            Text(
                  text = "Home Screen",
                  style = MaterialTheme.typography.titleLarge
            )
            Button(onClick = onDashboardClick) { Text("Go to Dashboard") }
            Button(onClick = onSettingsClick) { Text("Go to Settings") }
            Button(onClick = onProfileClick) { Text("Go to Profile") }
            Button(onClick = onPostClick) { Text("Go to Post") }
            Button(onClick = onNotificationClick) { Text("Go to Notifications") }
            Button(onClick = onFileUploadClick) { Text("Go to Upload File") }
      }
}