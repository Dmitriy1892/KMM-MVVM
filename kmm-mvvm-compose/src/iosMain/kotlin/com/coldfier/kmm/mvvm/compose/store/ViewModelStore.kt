package com.coldfier.kmm.mvvm.compose.store

import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory

actual class ViewModelStore {

    private val viewModels = mutableMapOf<String, BaseViewModel>()

    fun <T: BaseViewModel> getOrCreate(
        key: String,
        viewModelCreationKey: String,
        viewModelFactory: BaseViewModelFactory
    ): T {
        val cachedViewModel = viewModels[key]
        return if (cachedViewModel == null) {
            val newViewModel = viewModelFactory.create<T>(viewModelCreationKey)
            viewModels[key] = newViewModel

            newViewModel
        } else cachedViewModel as T
    }

    actual fun remove(key: String) {
        viewModels.remove(key)?.clear()
    }
}