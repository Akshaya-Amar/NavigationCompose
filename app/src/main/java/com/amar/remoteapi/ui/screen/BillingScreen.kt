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
fun BillingScreen(
      modifier: Modifier = Modifier,
      onPlanClick: () -> Unit,
      onPaymentMethodsClick: () -> Unit,
      onInvoiceClick: () -> Unit,
      onHistoryClick: () -> Unit
) {
      Column(
            modifier = Modifier
                  .fillMaxSize()
                  .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
      ) {
            Text(
                  text = "Billing Screen",
                  style = MaterialTheme.typography.titleLarge
            )
            Button(onClick = onPlanClick) { Text(text = "Go to Plans Screen") }
            Button(onClick = onPaymentMethodsClick) { Text(text = "Go to Payment Methods Screen") }
            Button(onClick = onInvoiceClick) { Text(text = "Go to Invoice Screen") }
            Button(onClick = onHistoryClick) { Text(text = "Go to History Screen") }
      }
}