package com.coldfier.kmm.mvvm.compose

import com.coldfier.kmm.mvvm.compose.store.ViewModelStore
import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory
import com.coldfier.kmm.mvvm.core.viewModelKey

actual inline fun <reified T: BaseViewModel> kmmViewModelInternal(
    key: String?,
    factory: BaseViewModelFactory,
    store: ViewModelStore?
): T {
    checkNotNull(store) { "ViewModelStore not provided" }

    val vmKey = key ?: T::class.viewModelKey()
    return store.getOrCreate(vmKey, T::class.viewModelKey(), factory)
}