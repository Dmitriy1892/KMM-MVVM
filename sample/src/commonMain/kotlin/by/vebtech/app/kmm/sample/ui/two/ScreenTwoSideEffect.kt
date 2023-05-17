package by.vebtech.app.kmm.sample.ui.two

sealed class ScreenTwoSideEffect() {

    object ShowSuccess : ScreenTwoSideEffect()

    object ShowError : ScreenTwoSideEffect()

    object CloseScreen : ScreenTwoSideEffect()
}