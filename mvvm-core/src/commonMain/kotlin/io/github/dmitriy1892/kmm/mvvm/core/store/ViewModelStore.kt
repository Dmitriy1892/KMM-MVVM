package io.github.dmitriy1892.kmm.mvvm.core.store

import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory

class ViewModelStore {

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

    fun remove(key: String) {
        viewModels.remove(key)?.clear()
    }

    fun clear() {
        viewModels.values.forEach { it.clear() }
        viewModels.clear()
    }
}