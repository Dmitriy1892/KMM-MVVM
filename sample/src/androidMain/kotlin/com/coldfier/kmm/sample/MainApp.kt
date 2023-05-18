package com.coldfier.kmm.sample

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.coldfier.kmm.sample.sample.App
import com.coldfier.kmm.sample.sample.di.KoinDiHolder
import com.coldfier.kmm.mvvm.koin.factory.KoinViewModelFactory
import com.coldfier.kmm.utils.platform.PlatformConfiguration

@Composable
fun MainApp() {
    val platformConfiguration = PlatformConfiguration(LocalContext.current.applicationContext)
    val koin = KoinDiHolder.getInstance(platformConfiguration).koin

    App(viewModelStore = koin.get(), viewModelFactory = KoinViewModelFactory())
}