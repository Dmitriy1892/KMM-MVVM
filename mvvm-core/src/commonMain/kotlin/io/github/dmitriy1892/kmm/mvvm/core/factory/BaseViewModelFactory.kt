package io.github.dmitriy1892.kmm.mvvm.core.factory

import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel

expect interface BaseViewModelFactory {

    fun <T: BaseViewModel> create(key: String): T
}