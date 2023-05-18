package com.coldfier.kmm.sample.sample.ui.two

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.coldfier.kmm.mvvm.compose.KmmViewModelStore
import com.coldfier.kmm.mvvm.compose.kmmViewModel
import com.coldfier.kmm.mvvm.core.viewModelKey
import com.coldfier.kmm.mvvm.koin.factory.KoinAssistedViewModelFactory
import org.koin.core.parameter.parametersOf

@Composable
fun ScreenTwo(
    argument: String,
    viewModel: ScreenTwoViewModel =
        kmmViewModel(factory = KoinAssistedViewModelFactory(parametersOf(argument))),
    onBack: () -> Unit
) {
    val state by viewModel.screenState.collectAsState()
    val sideEffect by viewModel.sideEffectFlow.collectAsState(initial = null)

    var oneTimeEvent = remember { "" }

    when (val effect = sideEffect) {
        ScreenTwoSideEffect.ShowError -> oneTimeEvent = "Error"
        ScreenTwoSideEffect.ShowSuccess -> oneTimeEvent = "Success"
        ScreenTwoSideEffect.CloseScreen -> {
            KmmViewModelStore.current.remove(viewModel::class.viewModelKey())
            onBack()
        }
        null -> oneTimeEvent = ""
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Argument from previous screen: ${state.infoFromFirstScreen}")

            Text(text = "One-time event: $oneTimeEvent")

            Button(onClick = { viewModel.showMessage(true) }) {
                Text(text = "Show success")
            }

            Button(onClick = { viewModel.showMessage(false) }) {
                Text(text = "Show error")
            }

            Button(onClick = {
                viewModel.closeScreen()
            }) {
                Text(text = "Get back")
            }
        }
    }
}