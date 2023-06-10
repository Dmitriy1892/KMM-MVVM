package io.github.dmitriy1892.kmm.mvvm.koin.factory

import androidx.lifecycle.ViewModel
import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory
import io.github.dmitriy1892.kmm.mvvm.core.viewModelKey
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.ParametersHolder
import org.koin.core.qualifier.qualifier

actual class KoinAssistedViewModelFactory actual constructor(
    private val assistedArgs: ParametersHolder
) : BaseViewModelFactory, KoinComponent {

    actual override fun <T : BaseViewModel> create(key: String): T {
        return this.get<BaseViewModel>(qualifier = qualifier(key)) { assistedArgs } as T
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return create(modelClass.viewModelKey())
    }
}