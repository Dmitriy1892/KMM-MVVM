package io.github.dmitriy1892.kmm.sample.sample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import io.github.dmitriy1892.kmm.mvvm.compose.ComposeViewModelApp
import io.github.dmitriy1892.kmm.mvvm.compose.store.ViewModelStore
import io.github.dmitriy1892.kmm.mvvm.core.factory.BaseViewModelFactory
import io.github.dmitriy1892.kmm.sample.sample.ui.one.ScreenOne
import io.github.dmitriy1892.kmm.sample.sample.ui.two.ScreenTwo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlin.native.concurrent.ThreadLocal

@Composable
fun App(
    viewModelStore: ViewModelStore,
    viewModelFactory: BaseViewModelFactory
) {
    ComposeViewModelApp(
        viewModelStore = viewModelStore,
        viewModelFactory = viewModelFactory
    ) {
        val currentScreen: NavGraph by Navigator.currentScreen.collectAsState()

        when (val screen = currentScreen) {
            is NavGraph.ScreenOne -> {
                ScreenOne(onNavigate =  { argumnent ->
                    Navigator.navigate(argumnent)
                })
            }

            is NavGraph.ScreenTwo -> {
                ScreenTwo(argument = screen.argument) {
                    Navigator.back()
                }
            }
        }
    }
}

@ThreadLocal
object Navigator {

    var currentScreen: MutableStateFlow<NavGraph> = MutableStateFlow(NavGraph.ScreenOne)

    fun navigate(arg: String) {
        currentScreen.update { NavGraph.ScreenTwo(arg) }
    }

    fun back() {
        currentScreen.update { NavGraph.ScreenOne }
    }
}

sealed class NavGraph {

    object ScreenOne : NavGraph()

    class ScreenTwo(val argument: String) : NavGraph()
}