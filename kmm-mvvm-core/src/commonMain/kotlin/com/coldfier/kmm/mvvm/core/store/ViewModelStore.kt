package com.coldfier.kmm.mvvm.core.store

import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory

class ViewModelStore {

    private val viewModels = mutableMapOf<String, BaseViewModel>()

    fun add(key: String, viewModel: BaseViewModel) {
        if (viewModels[key] == null) viewModels[key] = viewModel
    }
    
    fun <T: BaseViewModel> get(key: String): T = viewModels[key] as T

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

    fun remove(key: String) = viewModels.remove(key)
}