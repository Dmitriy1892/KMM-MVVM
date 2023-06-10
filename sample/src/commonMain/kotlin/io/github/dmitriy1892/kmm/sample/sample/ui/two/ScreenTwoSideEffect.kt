package io.github.dmitriy1892.kmm.sample.sample.ui.two

sealed class ScreenTwoSideEffect() {

    object ShowSuccess : ScreenTwoSideEffect()

    object ShowError : ScreenTwoSideEffect()

    object CloseScreen : ScreenTwoSideEffect()
}