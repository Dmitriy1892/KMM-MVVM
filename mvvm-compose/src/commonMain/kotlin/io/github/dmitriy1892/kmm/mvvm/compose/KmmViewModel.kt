package io.github.dmitriy1892.kmm.mvvm.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import io.github.dmitriy1892.kmm.mvvm.compose.store.ViewModelStore
import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory

val KmmViewModelStore = compositionLocalOf<ViewModelStore> {
    error("ViewModelStore is not provided to the CompositionLocal named 'KmmViewModelStore'")
}

val KmmViewModelFactory = compositionLocalOf<BaseViewModelFactory> {
    error("ViewModelFactory is not provided to the CompositionLocal named 'KmmViewModelFactory'")
}

/**
 * Use it with Android Jetpack Compose
 */
@Composable
inline fun <reified T: BaseViewModel> androidComposeViewModel(
    key: String? = null,
    factory: BaseViewModelFactory = KmmViewModelFactory.current,
): T = kmmViewModelInternal(key, factory, true, KmmViewModelStore.current)

/**
 * Use it with Compose Multiplatform
 */
@Composable
inline fun <reified T: BaseViewModel> kmmViewModel(
    key: String? = null,
    factory: BaseViewModelFactory = KmmViewModelFactory.current,
): T = kmmViewModelInternal(key, factory, false, KmmViewModelStore.current)

@Deprecated("Please use 'kmmViewModel' function")
@Composable
expect inline fun <reified T: BaseViewModel> kmmViewModelInternal(
    key: String? = null,
    factory: BaseViewModelFactory,
    isUseAndroidViewModelStore: Boolean,
    store: ViewModelStore? = null
): T