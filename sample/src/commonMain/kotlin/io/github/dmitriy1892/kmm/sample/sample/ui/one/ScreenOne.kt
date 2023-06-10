package io.github.dmitriy1892.kmm.sample.sample.ui.one

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.dmitriy1892.kmm.mvvm.compose.KmmViewModelStore
import io.github.dmitriy1892.kmm.mvvm.compose.kmmViewModel
import io.github.dmitriy1892.kmm.mvvm.core.viewModelKey

@Composable
fun ScreenOne(
    viewModel: ScreenOneViewModel = kmmViewModel(),
    onNavigate: @Composable (arg: String) -> Unit
) {
    val state by viewModel.screenState.collectAsState()
    val sideEffect by viewModel.sideEffectFlow.collectAsState(initial = null)

    when (val effect = sideEffect) {
        is ScreenOneSideEffect.OpenSecondScreen -> {
            if (effect.needToRemoveFirstScreen)
                KmmViewModelStore.current.remove(ScreenOneViewModel::class.viewModelKey())

            onNavigate(effect.argument)
        }
        null -> {}
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Saved value: ${state.userInput}")

            Button(onClick = { viewModel.navigate(false) }) {
                Text(text = "Navigate")
            }

            Button(onClick = { viewModel.navigate(true) }) {
                Text(text = "Navigate with pop current screen")
            }
        }
    }
}