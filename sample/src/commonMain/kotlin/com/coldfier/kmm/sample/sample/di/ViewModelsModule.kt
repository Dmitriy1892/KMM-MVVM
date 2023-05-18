package com.coldfier.kmm.sample.sample.di

import com.coldfier.kmm.mvvm.compose.store.ViewModelStore
import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory
import com.coldfier.kmm.mvvm.core.viewModelKey
import com.coldfier.kmm.mvvm.koin.factory.KoinViewModelFactory
import com.coldfier.kmm.sample.sample.ui.one.ScreenOneViewModel
import com.coldfier.kmm.sample.sample.ui.two.ScreenTwoViewModel
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