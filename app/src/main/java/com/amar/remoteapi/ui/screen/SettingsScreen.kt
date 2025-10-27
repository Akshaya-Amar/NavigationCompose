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
fun SettingsScreen(
      modifier: Modifier = Modifier,
      onAccountClick: () -> Unit,
      onHelpClick: () -> Unit,
      onAboutClick: () -> Unit,
      onTermsClick: () -> Unit,
      onBillingClick: () -> Unit
) {
      Column(
            modifier = Modifier
                  .fillMaxSize()
                  .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(
                  16.dp,
                  alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
      ) {
            Text(
                  text = "Settings Screen",
                  style = MaterialTheme.typography.titleLarge
            )
            Button(onClick = onAccountClick) { Text(text = "Go to Account Screen") }
            Button(onClick = onHelpClick) { Text(text = "Go to Help Screen") }
            Button(onClick = onAboutClick) { Text(text = "Go to About Screen") }
            Button(onClick = onTermsClick) { Text(text = "Go to Terms Screen") }
            Button(onClick = onBillingClick) { Text(text = "Go to Billing Screen") }
      }
}