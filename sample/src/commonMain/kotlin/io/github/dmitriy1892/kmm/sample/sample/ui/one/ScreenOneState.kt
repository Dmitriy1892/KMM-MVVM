package io.github.dmitriy1892.kmm.sample.sample.ui.one

data class ScreenOneState(
    val userInput: String = getRandomString()
)

fun getRandomString(length: Int = 10) : String {
    val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}