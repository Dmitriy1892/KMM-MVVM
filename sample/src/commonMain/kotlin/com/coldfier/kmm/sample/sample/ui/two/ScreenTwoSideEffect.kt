package com.coldfier.kmm.sample.sample.ui.two

sealed class ScreenTwoSideEffect() {

    object ShowSuccess : ScreenTwoSideEffect()

    object ShowError : ScreenTwoSideEffect()

    object CloseScreen : ScreenTwoSideEffect()
}