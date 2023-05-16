package com.coldfier.kmm.mvvm.koin.factory

import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.qualifier.qualifier

actual class KoinViewModelFactory : BaseViewModelFactory, KoinComponent {

    actual override fun <T: BaseViewModel> create(key: String): T {
        return this.get<BaseViewModel>(qualifier(key)) as T
    }
}