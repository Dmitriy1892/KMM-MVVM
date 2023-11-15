package io.github.dmitriy1892.kmm.mvvm.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import io.github.dmitriy1892.kmm.mvvm.core.store.ViewModelStore
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
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