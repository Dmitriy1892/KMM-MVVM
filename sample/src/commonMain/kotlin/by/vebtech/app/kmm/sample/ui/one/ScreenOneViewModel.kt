package by.vebtech.app.kmm.sample.ui.one

import com.coldfier.kmm.mvvm.core.MviViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ScreenOneViewModel : MviViewModel<ScreenOneState, ScreenOneSideEffect>() {

    override val _screenState: MutableStateFlow<ScreenOneState> = MutableStateFlow(ScreenOneState())

    fun setInput(input: String) {
        _screenState.update { it.copy(userInput = input) }
    }

    fun navigate(withPopBackStack: Boolean) {
        kmmViewModelScope.launch {
            val effect = ScreenOneSideEffect.OpenSecondScreen(
                argument = _screenState.value.userInput,
                needToRemoveFirstScreen = withPopBackStack
            )

            sideEffectChannel.send(effect)
        }
    }
}