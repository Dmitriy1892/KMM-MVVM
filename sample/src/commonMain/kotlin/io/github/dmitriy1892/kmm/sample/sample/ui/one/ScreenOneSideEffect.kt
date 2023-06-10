package io.github.dmitriy1892.kmm.sample.sample.ui.one

sealed class ScreenOneSideEffect() {

    class OpenSecondScreen(
        val argument: String,
        val needToRemoveFirstScreen: Boolean
    ) : ScreenOneSideEffect()
}