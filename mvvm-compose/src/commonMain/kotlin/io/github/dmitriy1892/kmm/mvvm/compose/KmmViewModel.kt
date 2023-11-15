package io.github.dmitriy1892.kmm.mvvm.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import io.github.dmitriy1892.kmm.mvvm.core.store.ViewModelStore
import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel
import io.github.dmitriy1892.kmm.mvvm.core.InternalKmmMvvmApi
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory
import io.github.dmitriy1892.kmm.mvvm.core.viewModelKey
import kotlin.experimental.ExperimentalObjCRefinement
import kotlin.native.HiddenFromObjC

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
val KmmViewModelStore = compositionLocalOf<ViewModelStore> {
    error("ViewModelStore is not provided to the CompositionLocal named 'KmmViewModelStore'")
}

@OptIn(ExperimentalObjCRefinement::class)
@HiddenFromObjC
val KmmViewModelFactory = compositionLocalOf<BaseViewModelFactory> {
    error("ViewModelFactory is not provided to the CompositionLocal named 'KmmViewModelFactory'")
}

/**
 * Use it with Compose Multiplatform
 */
@OptIn(InternalKmmMvvmApi::class, ExperimentalObjCRefinement::class)
@HiddenFromObjC
@Composable
inline fun <reified T: BaseViewModel> kmmViewModel(
    key: String? = null,
    factory: BaseViewModelFactory = KmmViewModelFactory.current
): T = provideKmmViewModel(key, factory, KmmViewModelStore.current)

// Cannot to use T::class inside @Composable-function with generic type.
// Issue: https://github.com/JetBrains/compose-multiplatform/issues/3147
@InternalKmmMvvmApi
inline fun <reified T: BaseViewModel> provideKmmViewModel(
    key: String?,
    factory: BaseViewModelFactory,
    viewModelStore: ViewModelStore
): T {
    val vmKey = key ?: T::class.viewModelKey()
    return viewModelStore.getOrCreate(vmKey, T::class.viewModelKey(), factory)
}