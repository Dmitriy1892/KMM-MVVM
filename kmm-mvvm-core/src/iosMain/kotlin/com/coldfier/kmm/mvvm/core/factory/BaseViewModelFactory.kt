package com.coldfier.kmm.mvvm.core.factory

import com.coldfier.kmm.mvvm.core.BaseViewModel

actual interface BaseViewModelFactory {

    actual fun <T: BaseViewModel> create(key: String): T
}