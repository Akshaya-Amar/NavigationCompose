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
fun DashboardScreen(
      modifier: Modifier = Modifier,
      onOverviewClicked: () -> Unit,
      onAnalyticClicked: () -> Unit,
      onReportClicked: () -> Unit,
      onQuickActionClicked: () -> Unit
) {
      Column(
            modifier = Modifier
                  .fillMaxSize()
                  .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
      ) {
            Text(
                  text = "Dashboard Screen",
                  style = MaterialTheme.typography.titleLarge
            )
            Button(onClick = onOverviewClicked) { Text("Go to Overview") }
            Button(onClick = onAnalyticClicked) { Text("Go to Analytics") }
            Button(onClick = onReportClicked) { Text("Go to Report") }
            Button(onClick = onQuickActionClicked) { Text("Go to Quick Action") }
      }
}