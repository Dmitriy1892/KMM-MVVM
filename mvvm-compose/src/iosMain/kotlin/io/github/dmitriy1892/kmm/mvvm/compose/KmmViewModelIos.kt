package io.github.dmitriy1892.kmm.mvvm.compose

import io.github.dmitriy1892.kmm.mvvm.compose.store.ViewModelStore
import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory
import io.github.dmitriy1892.kmm.mvvm.core.viewModelKey

actual inline fun <reified T: BaseViewModel> kmmViewModelInternal(
    key: String?,
    factory: BaseViewModelFactory,
    isUseAndroidViewModelStore: Boolean,
    store: ViewModelStore?
): T {
    checkNotNull(store) { "ViewModelStore not provided" }

    val vmKey = key ?: T::class.viewModelKey()
    return store.getOrCreate(vmKey, T::class.viewModelKey(), factory)
}