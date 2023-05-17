package com.coldfier.kmm.mvvm.compose.store

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner

actual class ViewModelStore actual constructor() {

    @Composable
    actual fun remove(key: String) {
        LocalViewModelStoreOwner.current?.viewModelStore?.remove(key)
    }
}

@Composable
private fun androidx.lifecycle.ViewModelStore.remove(key: String) {
    val mapField = androidx.lifecycle.ViewModelStore::class.java.getDeclaredField("map")
    mapField.isAccessible = true
    val map = mapField.get(this) as MutableMap<String, ViewModel>
    val deletedViewModel = map.remove(key)

    deletedViewModel?.let { viewModel ->
        val vmMethod = ViewModel::class.java.getDeclaredMethod("clear")
        vmMethod.isAccessible = true
        vmMethod.invoke(viewModel)
    }
}