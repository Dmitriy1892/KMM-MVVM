package io.github.dmitriy1892.kmm.sample

import androidx.compose.ui.window.ComposeUIViewController
import io.github.dmitriy1892.kmm.sample.sample.App
import io.github.dmitriy1892.kmm.sample.sample.di.KoinDiHolder
import io.github.dmitriy1892.kmm.utils.platform.PlatformConfiguration

fun MainApp() = ComposeUIViewController {
    val platformConfiguration = PlatformConfiguration()
    val koin = KoinDiHolder.getInstance(platformConfiguration).koin
    App(viewModelStore = koin.get(), viewModelFactory = koin.get())
}