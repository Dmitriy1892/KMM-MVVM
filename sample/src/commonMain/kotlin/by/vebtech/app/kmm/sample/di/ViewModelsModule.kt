package by.vebtech.app.kmm.sample.di

import by.vebtech.app.kmm.sample.ui.one.ScreenOneViewModel
import by.vebtech.app.kmm.sample.ui.two.ScreenTwoViewModel
import com.coldfier.kmm.mvvm.compose.store.ViewModelStore
import com.coldfier.kmm.mvvm.core.BaseViewModel
import com.coldfier.kmm.mvvm.core.factory.BaseViewModelFactory
import com.coldfier.kmm.mvvm.core.viewModelKey
import com.coldfier.kmm.mvvm.koin.factory.KoinViewModelFactory
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