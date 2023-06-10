package io.github.dmitriy1892.kmm.sample

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import io.github.dmitriy1892.kmm.sample.sample.App
import io.github.dmitriy1892.kmm.sample.sample.di.KoinDiHolder
import io.github.dmitriy1892.kmm.utils.platform.PlatformConfiguration

@Composable
fun MainApp() {
    val platformConfiguration = PlatformConfiguration(LocalContext.current.applicationContext)
    val koin = KoinDiHolder.getInstance(platformConfiguration).koin

    App(viewModelStore = koin.get(), viewModelFactory = koin.get())
}