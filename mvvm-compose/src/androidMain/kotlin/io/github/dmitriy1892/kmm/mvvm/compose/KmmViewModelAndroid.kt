package io.github.dmitriy1892.kmm.mvvm.compose

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.dmitriy1892.kmm.mvvm.compose.store.ViewModelStore
import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory
import io.github.dmitriy1892.kmm.mvvm.core.viewModelKey

@Composable
actual inline fun <reified T: BaseViewModel> kmmViewModelInternal(
    key: String?,
    factory: BaseViewModelFactory,
    isUseAndroidViewModelStore: Boolean,
    store: ViewModelStore?
): T {
    return if (isUseAndroidViewModelStore) {
        viewModel(factory = factory)
    } else {
        checkNotNull(store) { "ViewModelStore not provided" }
        val vmKey = key ?: T::class.viewModelKey()
        store.getOrCreate(vmKey, T::class.viewModelKey(), factory)
    }
}