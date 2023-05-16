package com.coldfier.kmm.mvvm.core.factory

import androidx.lifecycle.ViewModelProvider
import com.coldfier.kmm.mvvm.core.BaseViewModel

actual interface BaseViewModelFactory : ViewModelProvider.Factory {

    actual fun <T: BaseViewModel> create(key: String): T
}