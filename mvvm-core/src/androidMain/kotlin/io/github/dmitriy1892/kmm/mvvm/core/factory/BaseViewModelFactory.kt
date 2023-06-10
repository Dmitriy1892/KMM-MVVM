package io.github.dmitriy1892.kmm.mvvm.core.factory

import androidx.lifecycle.ViewModelProvider
import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel

actual interface BaseViewModelFactory : ViewModelProvider.Factory {

    actual fun <T: BaseViewModel> create(key: String): T
}