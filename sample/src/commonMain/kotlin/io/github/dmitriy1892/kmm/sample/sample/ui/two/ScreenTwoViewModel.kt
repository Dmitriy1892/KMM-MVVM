package io.github.dmitriy1892.kmm.sample.sample.ui.two

import io.github.dmitriy1892.kmm.mvvm.core.UdfViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.InjectedParam

class ScreenTwoViewModel(
    @InjectedParam val argumentFromFirstScreen: String
) : UdfViewModel<ScreenTwoState, ScreenTwoSideEffect>() {

    override val _screenState: MutableStateFlow<ScreenTwoState> =
        MutableStateFlow(ScreenTwoState(argumentFromFirstScreen))

    fun showMessage(isSuccess: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val sideEffect = if (isSuccess) ScreenTwoSideEffect.ShowSuccess
                else ScreenTwoSideEffect.ShowError

            _sideEffectFlow.emit(sideEffect)
        }
    }

    fun closeScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            _sideEffectFlow.emit(ScreenTwoSideEffect.CloseScreen)
        }
    }
}