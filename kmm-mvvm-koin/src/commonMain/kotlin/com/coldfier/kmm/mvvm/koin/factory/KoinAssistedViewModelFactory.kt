package com.coldfier.kmm.mvvm.koin.factory

import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.ParametersHolder

expect class KoinAssistedViewModelFactory(
    assistedArgs: ParametersHolder
) : BaseViewModelFactory, KoinComponent {

    override fun <T: BaseViewModel> create(key: String): T
}