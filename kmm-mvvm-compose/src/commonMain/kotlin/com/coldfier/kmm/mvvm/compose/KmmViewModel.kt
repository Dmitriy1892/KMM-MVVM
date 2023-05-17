package com.coldfier.kmm.mvvm.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import com.coldfier.kmm.mvvm.compose.store.ViewModelStore
import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory

val KmmViewModelStore = compositionLocalOf<ViewModelStore> {
    error("ViewModelStore is not provided to the CompositionLocal named 'KmmViewModelStore'")
}

val KmmViewModelFactory = compositionLocalOf<BaseViewModelFactory> {
    error("ViewModelFactory is not provided to the CompositionLocal named 'KmmViewModelFactory'")
}

@Composable
inline fun <reified T: BaseViewModel> kmmViewModel(
    key: String? = null,
    factory: BaseViewModelFactory = KmmViewModelFactory.current,
): T = kmmViewModelInternal(key, factory, KmmViewModelStore.current)

@Deprecated("Please use 'kmmViewModel' function")
@Composable
expect inline fun <reified T: BaseViewModel> kmmViewModelInternal(
    key: String? = null,
    factory: BaseViewModelFactory,
    store: ViewModelStore? = null
): T