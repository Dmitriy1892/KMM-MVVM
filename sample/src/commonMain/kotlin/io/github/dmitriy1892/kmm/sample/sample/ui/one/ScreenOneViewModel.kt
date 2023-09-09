package io.github.dmitriy1892.kmm.sample.sample.ui.one

import io.github.dmitriy1892.kmm.mvvm.core.UdfViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ScreenOneViewModel : UdfViewModel<ScreenOneState, ScreenOneSideEffect>() {

    override val _screenState: MutableStateFlow<ScreenOneState> = MutableStateFlow(ScreenOneState())

    fun setInput(input: String) {
        _screenState.update { it.copy(userInput = input) }
    }

    fun navigate(withPopBackStack: Boolean) {
        viewModelScope.launch {
            val effect = ScreenOneSideEffect.OpenSecondScreen(
                argument = _screenState.value.userInput,
                needToRemoveFirstScreen = withPopBackStack
            )

            sideEffectChannel.send(effect)
        }
    }
}