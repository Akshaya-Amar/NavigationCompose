package com.amar.remoteapi.ui.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.amar.remoteapi.ui.BillingDestination
import com.amar.remoteapi.ui.screen.BillingScreen
import com.amar.remoteapi.ui.screen.HistoryScreen
import com.amar.remoteapi.ui.screen.InvoiceScreen
import com.amar.remoteapi.ui.screen.PaymentMethodScreen
import com.amar.remoteapi.ui.screen.PlanScreen

fun EntryProviderScope<NavKey>.billingNavGraph(backStack: MutableList<NavKey>) {
      entry<BillingDestination.Root> {
            BillingScreen(
                  onPlanClick = { backStack.add(BillingDestination.Plan) },
                  onPaymentMethodsClick = { backStack.add(BillingDestination.PaymentMethods) },
                  onInvoiceClick = { backStack.add(BillingDestination.Invoice) },
                  onHistoryClick = { backStack.add(BillingDestination.History) },
            )
      }

      entry<BillingDestination.Plan> {
            PlanScreen()
      }

      entry<BillingDestination.PaymentMethods> {
            PaymentMethodScreen()
      }

      entry<BillingDestination.Invoice> {
            InvoiceScreen()
      }

      entry<BillingDestination.History> {
            HistoryScreen()
      }
}