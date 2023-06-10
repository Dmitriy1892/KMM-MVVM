package io.github.dmitriy1892.kmm.mvvm.koin.factory

import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory
import org.koin.core.component.KoinComponent
import org.koin.core.parameter.ParametersHolder

expect class KoinAssistedViewModelFactory(
    assistedArgs: ParametersHolder
) : BaseViewModelFactory, KoinComponent {

    override fun <T: BaseViewModel> create(key: String): T
}