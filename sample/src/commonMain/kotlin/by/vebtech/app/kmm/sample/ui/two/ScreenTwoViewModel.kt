package by.vebtech.app.kmm.sample.ui.two

import com.coldfier.kmm.mvvm.core.MviViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.InjectedParam

class ScreenTwoViewModel(
    @InjectedParam val argumentFromFirstScreen: String
) : MviViewModel<ScreenTwoState, ScreenTwoSideEffect>() {

    override val _screenState: MutableStateFlow<ScreenTwoState> =
        MutableStateFlow(ScreenTwoState(argumentFromFirstScreen))

    fun showMessage(isSuccess: Boolean) {
        kmmViewModelScope.launch(Dispatchers.IO) {
            val sideEffect = if (isSuccess) ScreenTwoSideEffect.ShowSuccess
                else ScreenTwoSideEffect.ShowError

            sideEffectChannel.send(sideEffect)
        }
    }

    fun closeScreen() {
        kmmViewModelScope.launch(Dispatchers.IO) {
            sideEffectChannel.send(ScreenTwoSideEffect.CloseScreen)
        }
    }
}