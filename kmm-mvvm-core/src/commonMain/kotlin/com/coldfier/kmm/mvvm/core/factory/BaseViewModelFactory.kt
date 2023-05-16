package com.coldfier.kmm.mvvm.core.factory

import com.coldfier.kmm.mvvm.core.BaseViewModel

expect interface BaseViewModelFactory {

    fun <T: BaseViewModel> create(key: String): T
}