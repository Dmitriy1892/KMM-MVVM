package com.coldfier.kmm.mvvm.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.coldfier.kmm.mvvm.compose.store.ViewModelStore
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory

@Composable
fun ComposeViewModelApp(
    viewModelStore: ViewModelStore,
    viewModelFactory: BaseViewModelFactory,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        KmmViewModelFactory provides viewModelFactory,
        KmmViewModelStore provides viewModelStore
    ) {
        content()
    }
}