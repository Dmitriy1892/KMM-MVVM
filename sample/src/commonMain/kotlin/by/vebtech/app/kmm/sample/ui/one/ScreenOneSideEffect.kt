package by.vebtech.app.kmm.sample.ui.one

sealed class ScreenOneSideEffect() {

    class OpenSecondScreen(
        val argument: String,
        val needToRemoveFirstScreen: Boolean
    ) : ScreenOneSideEffect()
}