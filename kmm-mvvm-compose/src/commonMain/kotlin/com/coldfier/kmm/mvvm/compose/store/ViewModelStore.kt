package com.coldfier.kmm.mvvm.compose.store

import androidx.compose.runtime.Composable
import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory

expect class ViewModelStore() {

    @Composable
    fun remove(key: String)
}