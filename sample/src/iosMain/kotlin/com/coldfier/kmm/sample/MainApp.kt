package com.coldfier.kmm.sample

import androidx.compose.ui.window.ComposeUIViewController
import com.coldfier.kmm.sample.sample.di.KoinDiHolder
import com.coldfier.kmm.sample.sample.App
import com.coldfier.kmm.utils.platform.PlatformConfiguration

fun MainApp() = ComposeUIViewController {
    val platformConfiguration = PlatformConfiguration()
    val koin = KoinDiHolder.getInstance(platformConfiguration).koin
    App(viewModelStore = koin.get(), viewModelFactory = koin.get())
}