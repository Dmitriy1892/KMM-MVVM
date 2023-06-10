package io.github.dmitriy1892.kmm.mvvm.koin.factory

import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory
import org.koin.core.component.KoinComponent

expect class KoinViewModelFactory() : BaseViewModelFactory, KoinComponent {

    override fun <T : BaseViewModel> create(key: String): T
}