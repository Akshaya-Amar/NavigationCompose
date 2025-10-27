package com.amar.remoteapi.ui

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface BillingDestination : NavKey {
      @Serializable object Root : BillingDestination
      @Serializable object Plan : BillingDestination
      @Serializable object PaymentMethods : BillingDestination
      @Serializable object Invoice : BillingDestination
      @Serializable object History : BillingDestination
}
