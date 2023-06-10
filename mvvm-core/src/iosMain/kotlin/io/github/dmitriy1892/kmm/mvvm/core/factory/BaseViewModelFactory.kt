package io.github.dmitriy1892.kmm.mvvm.core.factory

import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel

actual interface BaseViewModelFactory {

    actual fun <T: BaseViewModel> create(key: String): T
}