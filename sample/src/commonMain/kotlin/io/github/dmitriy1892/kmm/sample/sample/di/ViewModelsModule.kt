package io.github.dmitriy1892.kmm.sample.sample.di

import io.github.dmitriy1892.kmm.mvvm.core.store.ViewModelStore
import io.github.dmitriy1892.kmm.mvvm.core.BaseViewModel
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory
import io.github.dmitriy1892.kmm.mvvm.core.viewModelKey
import io.github.dmitriy1892.kmm.mvvm.koin.factory.KoinViewModelFactory
import io.github.dmitriy1892.kmm.sample.sample.ui.one.ScreenOneViewModel
import io.github.dmitriy1892.kmm.sample.sample.ui.two.ScreenTwoViewModel
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val viewModelsModule = module {

    single<BaseViewModelFactory> { KoinViewModelFactory() }

    single<ViewModelStore> { ViewModelStore() }

    factory<BaseViewModel>(
        qualifier(ScreenOneViewModel::class.viewModelKey())
    ) { ScreenOneViewModel() }

    factory<BaseViewModel>(
        qualifier(ScreenTwoViewModel::class.viewModelKey())
    ) { params -> ScreenTwoViewModel(argumentFromFirstScreen = params.get()) }
}