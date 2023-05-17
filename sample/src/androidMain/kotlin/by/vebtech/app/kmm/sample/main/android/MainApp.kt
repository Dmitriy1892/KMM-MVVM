package by.vebtech.app.kmm.sample.main.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import by.vebtech.app.kmm.sample.App
import by.vebtech.app.kmm.sample.di.KoinDiHolder
import com.coldfier.kmm.mvvm.koin.factory.KoinViewModelFactory
import com.coldfier.kmm.utils.platform.PlatformConfiguration

@Composable
fun MainApp() {
    val platformConfiguration = PlatformConfiguration(LocalContext.current.applicationContext)
    val koin = KoinDiHolder.getInstance(platformConfiguration).koin

    App(viewModelStore = koin.get(), viewModelFactory = KoinViewModelFactory())
}