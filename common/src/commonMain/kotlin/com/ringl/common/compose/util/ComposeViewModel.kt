package com.ringl.common.compose.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

internal abstract class ComposeViewModel {

    protected val coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    fun onInit() {}

    fun onClear() {
        coroutineScope.cancel()
    }

}

@Composable
internal fun <T : ComposeViewModel> rememberComposeViewModel(
    composeViewModelFactory: () -> T
): T {
    return remember { CompositionScopedViewModelCanceller(composeViewModelFactory()) }.composeViewModel
}

internal class CompositionScopedViewModelCanceller<T : ComposeViewModel>(
    val composeViewModel: T
) : RememberObserver {

    override fun onRemembered() {
        composeViewModel.onInit()
    }

    override fun onForgotten() {
        composeViewModel.onClear()
    }

    override fun onAbandoned() {
        composeViewModel.onClear()
    }

}